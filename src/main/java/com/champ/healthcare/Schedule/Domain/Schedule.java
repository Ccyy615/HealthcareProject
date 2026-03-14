package com.champ.healthcare.Schedule.Domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor(force = true)
@Getter
@Setter
@EqualsAndHashCode
@Builder
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Clinic")
    private Clinic clinic;

    @Column(name = "doctor_id", columnDefinition = "UUID")
    private UUID doctorId;

    @Column(name = "patient_id", columnDefinition = "UUID")
    private UUID patientId;



    private WeeklyTimeRange weeklyTimeRange;
    private TimeSlotBlocked timeSlotBlocked;
}
