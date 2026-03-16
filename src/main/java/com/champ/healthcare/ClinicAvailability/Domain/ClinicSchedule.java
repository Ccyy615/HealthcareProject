package com.champ.healthcare.ClinicAvailability.Domain;

import com.champ.healthcare.Appointment.Domain.TimeSlot;
import com.champ.healthcare.Doctor.Domain.DoctorIdentifier;
import jakarta.persistence.*;
import lombok.*;

import java.time.*;
import java.util.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor(force = true)
@Getter
@Setter
@EqualsAndHashCode
@Builder
@Table(name= "clinic_schedules")
public class ClinicSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "clinic_id")
    private Long clinicId;


    @Column(name = "doctor_id")
    private DoctorIdentifier doctorId;

    @Embedded
    private ClinicLocation clinicLocation;

    @Enumerated(EnumType.STRING)
    @Column(name = "clinic_status")
    private ClinicStatus clinicStatus;

    @Builder.Default
    @Column(name = "is_open")
    private Boolean isOpen = false;

    @Column(name = "slot_duration")
    private Integer slotDurationMinutes;

    @ElementCollection
    private List<WeeklyTimeRange> weeklyHours = new ArrayList<>();

    @ElementCollection
    private List<TimeSlotBlocked> blockedSlots = new ArrayList<>();



//     /**
//     *******************************
//     *******************************
//     **/

    public void openClinic() {

        if (clinicStatus != ClinicStatus.OPEN) {
            throw new IllegalStateException("Clinic must be open.");
        }

        if (!isWithinWeeklyHoursNow()) {
            throw new IllegalStateException("Cannot open clinic: outside weekly hours.");
        }

        this.isOpen = true;
    }

    public void addBlockedSlot(TimeSlotBlocked newSlotBlocked) {

        boolean insideWeeklyHours = weeklyHours.stream().anyMatch(range ->
                !newSlotBlocked.getBlock_startTime().isBefore(range.getClinic_startTime()) &&
                        !newSlotBlocked.getBlock_endTime().isAfter(range.getClinic_endTime())
        );

        if (!insideWeeklyHours) {
            throw new IllegalArgumentException("Blocked slot must be inside weekly hours.");
        }

        for (TimeSlotBlocked slot : blockedSlots) {

            boolean overlap =
                    newSlotBlocked.getBlock_startTime().isBefore(slot.getBlock_endTime()) &&
                            newSlotBlocked.getBlock_endTime().isAfter(slot.getBlock_startTime());

            if (overlap) {
                throw new IllegalArgumentException("Blocked slot overlaps existing slot");
            }
        }

        blockedSlots.add(newSlotBlocked);
    }

//    public void addBlockedSlot(TimeSlotBlocked newSlotBlocked) {
//
//        for (TimeSlotBlocked slot : blockedSlots) {
//            boolean overlap =
//                    newSlotBlocked.getBlock_startTime().isBefore(slot.getBlock_endTime()) &&
//                            newSlotBlocked.getBlock_endTime().isAfter(slot.getBlock_startTime());
//            if (overlap) {
//                throw new IllegalArgumentException("Blocked slot overlaps existing slot");
//            }
//        }
//        blockedSlots.add(newSlotBlocked);
//    }

    private boolean isWithinWeeklyHoursNow() {

        DayOfWeek today = DayOfWeek.from(java.time.LocalDate.now());
        LocalTime now = LocalTime.now();

        return weeklyHours.stream().anyMatch(range ->
                range.getDayOfWeek() == today &&
                        !now.isBefore(range.getClinic_startTime()) &&
                        !now.isAfter(range.getClinic_endTime())
        );
    }



    public boolean isSlotAvailable(TimeSlot appointmentSlot) {
        // Get the date of the appointment
        LocalDate appointmentDate = appointmentSlot.getStartTime().toLocalDate();

        boolean withinWeeklyHours = weeklyHours.stream()
                .filter(range -> range.getDayOfWeek() == appointmentSlot.getStartTime().getDayOfWeek())
                .anyMatch(range -> {
                    LocalDateTime start = LocalDateTime.of(appointmentDate, range.getClinic_startTime());
                    LocalDateTime end = LocalDateTime.of(appointmentDate, range.getClinic_endTime());
                    return !appointmentSlot.getStartTime().isBefore(start) &&
                            !appointmentSlot.getEndTime().isAfter(end);
                });

        if (!withinWeeklyHours) return false;

        boolean overlapsBlocked = blockedSlots.stream().anyMatch(blocked -> {
            LocalDateTime blockedStart = LocalDateTime.of(appointmentDate, blocked.getBlock_startTime());
            LocalDateTime blockedEnd = LocalDateTime.of(appointmentDate, blocked.getBlock_endTime());
            return appointmentSlot.getStartTime().isBefore(blockedEnd) &&
                    appointmentSlot.getEndTime().isAfter(blockedStart);
        });

        return !overlapsBlocked;
    }



}

