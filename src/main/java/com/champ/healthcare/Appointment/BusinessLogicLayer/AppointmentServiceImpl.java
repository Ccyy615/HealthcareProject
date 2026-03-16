package com.champ.healthcare.Appointment.BusinessLogicLayer;

import com.champ.healthcare.Appointment.DataAccessLayer.AppointmentRepository;
import com.champ.healthcare.Appointment.Domain.Appointment;
import com.champ.healthcare.Appointment.Domain.AppointmentStatus;
import com.champ.healthcare.Appointment.Mapper.AppointmentMapper;
import com.champ.healthcare.Appointment.PresentationLayer.AppointmentRequestDTO;
import com.champ.healthcare.Appointment.PresentationLayer.AppointmentResponseDTO;
import com.champ.healthcare.Doctor.DataAccessLayer.DoctorRepository;
import com.champ.healthcare.Patient.DataAccessLayer.PatientRepository;
import com.champ.healthcare.utilities.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService{

    private final AppointmentRepository appointmentRepository;

    @Override
    @Transactional(readOnly = true)
    public List<AppointmentResponseDTO> getAllAppointments() {
        return AppointmentMapper.toResponseDTOList(appointmentRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public AppointmentResponseDTO getAppointmentById(Long appointmentId) {
        Appointment appointment = appointmentRepository
                .findByAppointmentId(appointmentId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Appointment not found with ID: " + appointmentId));
        return AppointmentMapper.toResponseDTO(appointment);
    }

    @Override
    @Transactional
    public AppointmentResponseDTO createAppointment(AppointmentRequestDTO dto) {
        Appointment appointment = AppointmentMapper.toEntity(dto);
        Appointment savedAppointment = appointmentRepository.save(appointment);
        return AppointmentMapper.toResponseDTO(savedAppointment);
    }

    @Override
    @Transactional
    public AppointmentResponseDTO updateAppointment(Long appointmentId, AppointmentRequestDTO dto) {

        Appointment appointment = appointmentRepository
                .findByAppointmentId(appointmentId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Appointment not found with ID: " + appointmentId));
        Appointment updateAppointment = AppointmentMapper.toEntity(dto);
        updateAppointment.setAppointmentId(appointmentId);
        updateAppointment.setStatus(appointment.getStatus());
        updateAppointment.setTimeSlot(appointment.getTimeSlot());

        Appointment savedAppointment = appointmentRepository.save(updateAppointment);
        return AppointmentMapper.toResponseDTO(savedAppointment);
    }

    @Override
    @Transactional
    public AppointmentResponseDTO deleteAppointment(Long appointmentId) {
        Appointment appointment = appointmentRepository
                .findByAppointmentId(appointmentId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Appointment not found with ID: " + appointmentId));
        appointmentRepository.delete(appointment);
        return AppointmentMapper.toResponseDTO(appointment);
    }

    @Override
    @Transactional
    public AppointmentResponseDTO completeAppointment(Long appointmentId) {
        Appointment appointment = appointmentRepository
                .findByAppointmentId(appointmentId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Appointment not found with ID: " + appointmentId));
        if (appointment.getStatus() != AppointmentStatus.IN_PROGRESS) {
            throw new IllegalStateException("Appointment must be IN_PROGRESS before it can be completed. Current status: " + appointment.getStatus());
        }
        appointment.setStatus(AppointmentStatus.COMPLETED);
        return AppointmentMapper.toResponseDTO(appointmentRepository.save(appointment));
    }

    @Override
    @Transactional
    public AppointmentResponseDTO cancelAppointment(Long appointmentId) {
        Appointment appointment = appointmentRepository
                .findByAppointmentId(appointmentId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Appointment not found with ID: " + appointmentId));
        if (appointment.getStatus() == AppointmentStatus.COMPLETED) {
            throw new IllegalStateException("A COMPLETED appointment cannot be cancelled.");
        }
        appointment.setStatus(AppointmentStatus.CANCELLED);
        return AppointmentMapper.toResponseDTO(appointmentRepository.save(appointment));
    }
}
