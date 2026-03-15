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
    private LocalDateTime dayOfWeek;

    private LocalTime startTime;
    private LocalTime endTime;
}
