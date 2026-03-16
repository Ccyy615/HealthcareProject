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

    @Column(name = "day_of_week")
    private DayOfWeek dayOfWeek;


    @Column(name = "clinic_start_time")
    private LocalTime clinic_startTime;

    @Column(name = "clinic_end_time")
    private LocalTime clinic_endTime;
}
