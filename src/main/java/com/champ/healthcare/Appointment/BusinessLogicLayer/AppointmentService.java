package com.champ.healthcare.Appointment.BusinessLogicLayer;

import com.champ.healthcare.Appointment.PresentationLayer.AppointmentController;
import com.champ.healthcare.Appointment.PresentationLayer.AppointmentRequestDTO;
import com.champ.healthcare.Appointment.PresentationLayer.AppointmentResponseDTO;
import com.champ.healthcare.Doctor.Domain.DoctorIdentifier;

import java.util.List;
import java.util.UUID;

public interface AppointmentService {

    List<AppointmentResponseDTO> getAllAppointments();
    AppointmentResponseDTO getAppointmentById(Long appointmentId);

    //List<AppointmentResponseDTO> getAppointmentsByDoctorId(DoctorIdentifier doctorId);

    AppointmentResponseDTO createAppointment(AppointmentRequestDTO appointmentRequestDTO);
    AppointmentResponseDTO updateAppointment(Long appointmentId, AppointmentRequestDTO appointmentRequestDTO);
    AppointmentResponseDTO deleteAppointment(Long appointmentId);

    AppointmentResponseDTO completeAppointment(Long appointmentId);
    AppointmentResponseDTO cancelAppointment(Long appointmentId);
}
