package com.champ.healthcare.ClinicAvailability.Domain;

import com.champ.healthcare.Doctor.Domain.DoctorIdentifier;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor(force = true)
@Getter
@Setter
@EqualsAndHashCode
@Builder
public class Schedule {

    @Id
    @GeneratedValue
    private Long scheduleId;

    private DoctorIdentifier doctorId;

    private Long clinicId;

    private Integer slotDurationMinutes;

    @ElementCollection
    private List<WeeklyTimeRange> weeklyHours = new ArrayList<>();

    @ElementCollection
    private List<TimeSlotBlocked> blockedSlots = new ArrayList<>();
}

