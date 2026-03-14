package com.champ.healthcare.Appointment.PresentationLayer;

import com.champ.healthcare.Appointment.Domain.TimeSlot;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

public class AppointmentResponseDTO {

    private UUID appointmentId;
    private String status;
    private LocalDateTime createdAt;
    private TimeSlot timeSlot;
    private String description;

    //Patient
    private UUID patientId;
    private String patientFullName;
    private String patientEmail;

    // Schedule
    private LocalDate scheduledDate;
    private LocalTime slotStartTime;
    private LocalTime slotEndTime;
    private Integer scheduleDuration;

}
