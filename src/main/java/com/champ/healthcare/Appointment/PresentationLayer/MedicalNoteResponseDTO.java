package com.champ.healthcare.Appointment.PresentationLayer;

import com.champ.healthcare.Appointment.Domain.Appointment;
import com.champ.healthcare.Appointment.Domain.NoteType;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MedicalNoteResponseDTO {

    private Long noteId;

    private Appointment appointmentId;
    private UUID doctorId;
    private UUID patientId;

    private String noteText;

    private LocalDateTime createdAt;

    private LocalDateTime lastUpdatedAt;

    private NoteType noteType;
}
