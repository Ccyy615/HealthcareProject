package com.champ.healthcare.Appointment.PresentationLayer;

import com.champ.healthcare.Appointment.Domain.Appointment;
import com.champ.healthcare.Appointment.Domain.NoteType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MedicalNoteRequestDTO {

    private Appointment appointmentId;
    private UUID doctorId;
    private UUID patientId;

    private String noteText;

    private LocalDateTime createdAt;

    private LocalDateTime lastUpdatedAt;

    private NoteType noteType;
}
