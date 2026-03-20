package com.champ.healthcare.Appointment.PresentationLayer;

import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentResponseDTO {

    private Long appointmentId;
    private String patientId;
    private String doctorId;
    private String roomId;

    private String status;
    private LocalDateTime createdAt;

    private LocalDateTime startTime;
    private LocalDateTime endTime;

    private String description;
}