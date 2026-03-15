package com.champ.healthcare.ClinicAvailability.Domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Embeddable
public class WeeklyTimeRange {

    @Enumerated(EnumType.STRING)
    private DayOfWeek dayOfWeek;

    @Column(name = "slot_start_time", nullable = false)
    private LocalTime clinic_startTime;

    @Column(name = "slot_end_time", nullable = false)
    private LocalTime clinic_endTime;
}
