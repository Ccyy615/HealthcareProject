package com.champ.healthcare.Appointment.Domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Embeddable
public class TimeSlot {

    @Column(name = "appointment_start")
    private LocalDateTime startTime;

    @Column(name = "appointment_end")
    private LocalDateTime endTime;
}
