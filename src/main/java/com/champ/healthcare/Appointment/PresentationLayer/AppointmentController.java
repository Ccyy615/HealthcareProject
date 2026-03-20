package com.champ.healthcare.Appointment.PresentationLayer;

import com.champ.healthcare.Appointment.BusinessLogicLayer.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/appointments")
@RequiredArgsConstructor
public class AppointmentController {

    private final AppointmentService appointmentService;

    @GetMapping
    public ResponseEntity<List<AppointmentResponseDTO>> getAllAppointments() {
        return ResponseEntity.ok(appointmentService.getAllAppointments());
    }

    @GetMapping("/{appointment_id}")
    public ResponseEntity<AppointmentResponseDTO> getAppointmentById(
            @PathVariable("appointment_id") Long appointmentId
    ) {
        return ResponseEntity.ok(appointmentService.getAppointmentById(appointmentId));
    }

    @GetMapping("/doctor/{doctorId}")
    public ResponseEntity<List<AppointmentResponseDTO>> getAppointmentsByDoctorId(
            @PathVariable String doctorId
    ) {
        return ResponseEntity.ok(appointmentService.getAppointmentsByDoctorId(doctorId));
    }

    @PostMapping
    public ResponseEntity<AppointmentResponseDTO> createAppointment(
            @RequestBody AppointmentRequestDTO dto
    ) {
        return ResponseEntity.ok(appointmentService.createAppointment(dto));
    }

    @PutMapping("/{appointment_id}")
    public ResponseEntity<AppointmentResponseDTO> updateAppointment(
            @PathVariable("appointment_id") Long appointmentId,
            @RequestBody AppointmentRequestDTO dto
    ) {
        return ResponseEntity.ok(appointmentService.updateAppointment(appointmentId, dto));
    }

    @DeleteMapping("/{appointment_id}")
    public ResponseEntity<AppointmentResponseDTO> deleteAppointment(
            @PathVariable("appointment_id") Long appointmentId
    ) {
        return ResponseEntity.ok(appointmentService.deleteAppointment(appointmentId));
    }

    @PatchMapping("/{appointment_id}/complete")
    public ResponseEntity<AppointmentResponseDTO> completeAppointment(
            @PathVariable("appointment_id") Long appointmentId
    ) {
        return ResponseEntity.ok(appointmentService.completeAppointment(appointmentId));
    }

    @PatchMapping("/{appointment_id}/cancel")
    public ResponseEntity<AppointmentResponseDTO> cancelAppointment(
            @PathVariable("appointment_id") Long appointmentId
    ) {
        return ResponseEntity.ok(appointmentService.cancelAppointment(appointmentId));
    }
}