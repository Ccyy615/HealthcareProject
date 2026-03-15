package com.champ.healthcare.Appointment.Domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
public class MedicalNote {

    @Id
    @GeneratedValue
    @Column(name = "note_id", columnDefinition = "UUID")
    private UUID noteID;

    private String appointmentId;
    private String authorDoctorId;

    private String noteText;
    private LocalDateTime createdAt;
    private LocalDateTime lastUpdatedAt;

    private NoteType noteType;


}
