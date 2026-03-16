package com.champ.healthcare.ClinicAvailability.Domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalTime;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor(force = true)
@Getter
@Setter
@EqualsAndHashCode
@Builder
public class TimeSlotBlocked {

    @Column(name = "block_start_time")
    private LocalTime block_startTime;

    @Column(name = "block_end_time")
    private LocalTime block_endTime;

}
