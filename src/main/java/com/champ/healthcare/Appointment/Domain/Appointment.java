package com.champ.healthcare.Appointment.Domain;

import com.champ.healthcare.Doctor.Domain.DoctorIdentifier;
import com.champ.healthcare.Patient.Domain.PatientIdentifier;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "appointments")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Appointment {

    @Id
    @GeneratedValue
    @Column(name = "appointment_id", columnDefinition = "UUID")
    private UUID appointmentId;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private AppointmentStatus status;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "time_slot")
    private TimeSlot timeSlot;

    @Column(name = "descriptions", length = 5000)
    private String description;


    @Column(name = "patient_id", columnDefinition = "UUID")
    private UUID patientId;

    @Column(name = "doctor_id", columnDefinition = "UUID")
    private UUID doctorId;

    @Column(name = "clinic_id", columnDefinition = "UUID")
    private UUID clinicId;
}
