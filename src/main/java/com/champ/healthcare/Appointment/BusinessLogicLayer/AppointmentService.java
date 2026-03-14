package com.champ.healthcare.Appointment.BusinessLogicLayer;

import com.champ.healthcare.Appointment.PresentationLayer.AppointmentController;
import com.champ.healthcare.Appointment.PresentationLayer.AppointmentRequestDTO;
import com.champ.healthcare.Appointment.PresentationLayer.AppointmentResponseDTO;

import java.util.List;
import java.util.UUID;

public interface AppointmentService {

    List<AppointmentResponseDTO> getAllAppointments();
    AppointmentResponseDTO getAppointmentById(UUID appointmentId);
    AppointmentResponseDTO createAppointment(AppointmentRequestDTO appointmentRequestDTO);
    AppointmentResponseDTO updateAppointment(UUID appointmentId, AppointmentRequestDTO appointmentRequestDTO);
    AppointmentResponseDTO deleteAppointment(UUID appointmentId);

    AppointmentResponseDTO cancelAppointment(UUID appointmentId);
}
