package com.champ.healthcare.Appointment.Domain;

import jakarta.persistence.*;
import lombok.*;

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

    @Column(name = "patient_id", columnDefinition = "UUID")
    private UUID patientId;

    @Column(name = "doctor_id", columnDefinition = "UUID")
    private UUID doctorId;

    private TimeSlot timeSlot;
    private AppointmentStatus status;
    private String description;

}
