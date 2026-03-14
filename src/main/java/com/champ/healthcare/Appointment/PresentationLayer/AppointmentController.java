package com.champ.healthcare.Appointment.PresentationLayer;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/appointments")
@RequiredArgsConstructor
public class AppointmentController {

    @GetMapping
    public ResponseEntity<List<AppointmentResponseDTO>> getAllAppointments() {
        return null;
    }

    @GetMapping("/{appointmentId}")
    public ResponseEntity<AppointmentResponseDTO> getAppointmentById(@PathVariable UUID appointmentId) {
        return null;
    }

    @PostMapping
    public ResponseEntity<AppointmentResponseDTO> createAppointment(@RequestBody AppointmentRequestDTO dto) {
        return null;
    }

    @PutMapping("/{appointmentId}")
    public ResponseEntity<AppointmentResponseDTO> updateAppointment(@PathVariable UUID appointmentId, @RequestBody AppointmentRequestDTO dto) {
        return null;
    }

    @DeleteMapping("/{appointment}")
    public ResponseEntity<AppointmentResponseDTO> deleteAppointment(@PathVariable UUID appointmentId) {
        return null;
    }


}
