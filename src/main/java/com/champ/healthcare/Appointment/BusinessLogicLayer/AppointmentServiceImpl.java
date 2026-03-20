package com.champ.healthcare.Appointment.BusinessLogicLayer;

import com.champ.healthcare.Appointment.DataAccessLayer.AppointmentRepository;
import com.champ.healthcare.Appointment.Domain.Appointment;
import com.champ.healthcare.Appointment.Domain.AppointmentStatus;
import com.champ.healthcare.Appointment.Domain.TimeSlot;
import com.champ.healthcare.Appointment.Mapper.AppointmentMapper;
import com.champ.healthcare.Appointment.PresentationLayer.AppointmentRequestDTO;
import com.champ.healthcare.Appointment.PresentationLayer.AppointmentResponseDTO;
import com.champ.healthcare.ClinicRoom.DataAccessLayer.ClinicRoomRepository;
import com.champ.healthcare.ClinicRoom.Domain.ClinicRoom;
import com.champ.healthcare.ClinicRoom.Domain.ClinicRoomIdentifier;
import com.champ.healthcare.Doctor.Domain.DoctorIdentifier;
import com.champ.healthcare.Patient.Domain.PatientIdentifier;
import com.champ.healthcare.utilities.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final ClinicRoomRepository clinicRoomRepository;

    @Override
    @Transactional(readOnly = true)
    public List<AppointmentResponseDTO> getAllAppointments() {
        return AppointmentMapper.toResponseDTOList(appointmentRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public AppointmentResponseDTO getAppointmentById(Long appointmentId) {
        Appointment appointment = appointmentRepository.findByAppointmentId(appointmentId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Appointment not found with ID: " + appointmentId
                ));

        return AppointmentMapper.toResponseDTO(appointment);
    }

    @Override
    @Transactional(readOnly = true)
    public List<AppointmentResponseDTO> getAppointmentsByDoctorId(String doctorId) {
        return AppointmentMapper.toResponseDTOList(
                appointmentRepository.findByDoctorId_DoctorId(doctorId)
        );
    }

    @Override
    @Transactional
    public AppointmentResponseDTO createAppointment(AppointmentRequestDTO dto) {
        validateRequest(dto);

        ClinicRoom room = loadRoom(dto.getRoomId());

        if (!room.isAvailableForBooking()) {
            throw new IllegalStateException("Cannot create appointment: room is out of service.");
        }

        throwIfRoomDoubleBooked(dto.getRoomId(), dto.getStartTime(), dto.getEndTime(), null);

        Appointment appointment = AppointmentMapper.toEntity(dto);
        appointment.validateTimeSlot();

        Appointment savedAppointment = appointmentRepository.save(appointment);
        return AppointmentMapper.toResponseDTO(savedAppointment);
    }

    @Override
    @Transactional
    public AppointmentResponseDTO updateAppointment(Long appointmentId, AppointmentRequestDTO dto) {
        validateRequest(dto);

        Appointment appointment = appointmentRepository.findByAppointmentId(appointmentId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Appointment not found with ID: " + appointmentId
                ));

        ClinicRoom room = loadRoom(dto.getRoomId());

        if (!room.isAvailableForBooking()) {
            throw new IllegalStateException("Cannot update appointment: room is out of service.");
        }

        throwIfRoomDoubleBooked(dto.getRoomId(), dto.getStartTime(), dto.getEndTime(), appointmentId);

        appointment.setPatientId(new PatientIdentifier(dto.getPatientId()));
        appointment.setDoctorId(new DoctorIdentifier(dto.getDoctorId()));
        appointment.setRoomId(new ClinicRoomIdentifier(dto.getRoomId()));
        appointment.setTimeSlot(new TimeSlot(dto.getStartTime(), dto.getEndTime()));
        appointment.setDescription(dto.getDescription());

        if (dto.getStatus() != null) {
            appointment.setStatus(dto.getStatus());
        }

        appointment.validateTimeSlot();

        Appointment savedAppointment = appointmentRepository.save(appointment);
        return AppointmentMapper.toResponseDTO(savedAppointment);
    }

    @Override
    @Transactional
    public AppointmentResponseDTO deleteAppointment(Long appointmentId) {
        Appointment appointment = appointmentRepository.findByAppointmentId(appointmentId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Appointment not found with ID: " + appointmentId
                ));

        appointmentRepository.delete(appointment);
        return AppointmentMapper.toResponseDTO(appointment);
    }

    @Override
    @Transactional
    public AppointmentResponseDTO completeAppointment(Long appointmentId) {
        Appointment appointment = appointmentRepository.findByAppointmentId(appointmentId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Appointment not found with ID: " + appointmentId
                ));

        if (appointment.getStatus() == AppointmentStatus.CANCELLED) {
            throw new IllegalStateException("A CANCELLED appointment cannot be completed.");
        }

        if (appointment.getStatus() == AppointmentStatus.COMPLETED) {
            throw new IllegalStateException("Appointment is already COMPLETED.");
        }

        appointment.setStatus(AppointmentStatus.COMPLETED);
        return AppointmentMapper.toResponseDTO(appointmentRepository.save(appointment));
    }

    @Override
    @Transactional
    public AppointmentResponseDTO cancelAppointment(Long appointmentId) {
        Appointment appointment = appointmentRepository.findByAppointmentId(appointmentId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Appointment not found with ID: " + appointmentId
                ));

        if (appointment.getStatus() == AppointmentStatus.COMPLETED) {
            throw new IllegalStateException("A COMPLETED appointment cannot be cancelled.");
        }

        appointment.setStatus(AppointmentStatus.CANCELLED);
        return AppointmentMapper.toResponseDTO(appointmentRepository.save(appointment));
    }

    private ClinicRoom loadRoom(String roomId) {
        return clinicRoomRepository.findByRoomId_RoomId(roomId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Clinic room not found with roomId: " + roomId
                ));
    }

    private void throwIfRoomDoubleBooked(String roomId, java.time.LocalDateTime startTime, java.time.LocalDateTime endTime, Long appointmentIdToExclude) {
        boolean overlap;

        if (appointmentIdToExclude == null) {
            overlap = appointmentRepository
                    .existsByRoomId_RoomIdAndTimeSlot_StartTimeLessThanAndTimeSlot_EndTimeGreaterThan(
                            roomId,
                            endTime,
                            startTime
                    );
        } else {
            overlap = appointmentRepository
                    .existsByRoomId_RoomIdAndTimeSlot_StartTimeLessThanAndTimeSlot_EndTimeGreaterThanAndAppointmentIdNot(
                            roomId,
                            endTime,
                            startTime,
                            appointmentIdToExclude
                    );
        }

        if (overlap) {
            throw new IllegalStateException(
                    "Cannot create or update appointment: the clinic room is already booked for this time slot."
            );
        }
    }

    private void validateRequest(AppointmentRequestDTO dto) {
        if (dto.getPatientId() == null || dto.getPatientId().isBlank()) {
            throw new IllegalArgumentException("Patient ID is required.");
        }

        if (dto.getDoctorId() == null || dto.getDoctorId().isBlank()) {
            throw new IllegalArgumentException("Doctor ID is required.");
        }

        if (dto.getRoomId() == null || dto.getRoomId().isBlank()) {
            throw new IllegalArgumentException("Room ID is required.");
        }

        TimeSlot timeSlot = new TimeSlot(dto.getStartTime(), dto.getEndTime());
        timeSlot.validate();
    }
}