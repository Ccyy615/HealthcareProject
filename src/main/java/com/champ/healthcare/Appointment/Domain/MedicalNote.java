package com.champ.healthcare.Appointment.Domain;

import com.champ.healthcare.Doctor.Domain.DoctorIdentifier;
import com.champ.healthcare.Patient.Domain.PatientIdentifier;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "medical_notes")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MedicalNote {

    @Id
    @GeneratedValue
    @Column(name = "note_id")
    private Long noteId;

    @ManyToOne
    @JoinColumn(name = "appointment_id", nullable = false)
    private Appointment appointment;


    @Column(name = "doctor_id", columnDefinition = "UUID")
    private UUID doctorId;

    @Column(name = "patient_id", columnDefinition = "UUID")
    private UUID patientId;

    @Column(name = "text")
    private String noteText;

    @Column(name = "note_create_at")
    private LocalDateTime createdAt;

    @Column(name = "last_update")
    private LocalDateTime lastUpdatedAt;

    @Enumerated(EnumType.STRING)
    @Column(name = "note_type")
    private NoteType noteType;


}
