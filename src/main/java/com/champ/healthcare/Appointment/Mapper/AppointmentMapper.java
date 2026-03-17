package com.champ.healthcare.Appointment.Mapper;

import com.champ.healthcare.Appointment.Domain.Appointment;
import com.champ.healthcare.Appointment.PresentationLayer.AppointmentRequestDTO;
import com.champ.healthcare.Appointment.PresentationLayer.AppointmentResponseDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AppointmentMapper {

    public static AppointmentResponseDTO toResponseDTO(Appointment appointment) {
        if (appointment == null) return null;

        return AppointmentResponseDTO.builder()
                .appointmentId(appointment.getAppointmentId())
                .status(appointment.getStatus().name())
                .createdAt(appointment.getCreatedAt())
                .timeSlot(appointment.getTimeSlot())
                .description(appointment.getDescription())
                .clinicId(appointment.getClinic())
                .doctorId(appointment.getClinic().getDoctorId())
                .patientId(appointment.getPatientId())
                .build();
    }

    public static Appointment toEntity(AppointmentRequestDTO appointmentRequestDTO) {
        return Appointment.builder()
                .status(appointmentRequestDTO.getStatus())
                .createdAt(appointmentRequestDTO.getCreatedAt())
                .timeSlot(appointmentRequestDTO.getTimeSlot())
                .description(appointmentRequestDTO.getDescription())
                .clinic(appointmentRequestDTO.getClinicId())
                .patientId(appointmentRequestDTO.getPatientId())
                .build();
    }

    public static List<AppointmentResponseDTO> toResponseDTOList(List<Appointment> appointments) {
        return appointments.stream().map(AppointmentMapper::toResponseDTO).collect(Collectors.toList());
    }
}
