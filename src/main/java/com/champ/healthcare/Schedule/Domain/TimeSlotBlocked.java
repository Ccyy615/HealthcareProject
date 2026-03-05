package com.champ.healthcare.Schedule.Domain;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Embeddable
public class TimeSlotBlocked {

    private LocalTime startTime;
    private LocalTime endTime;
}
