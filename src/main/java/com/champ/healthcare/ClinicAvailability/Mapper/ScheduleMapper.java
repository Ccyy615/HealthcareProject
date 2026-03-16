package com.champ.healthcare.ClinicAvailability.Mapper;

import com.champ.healthcare.ClinicAvailability.Domain.*;
import com.champ.healthcare.ClinicAvailability.PresentationLayer.*;
import com.champ.healthcare.Doctor.Domain.DoctorIdentifier;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ScheduleMapper {

    public static ScheduleResponseDTO toResponseDTO(ClinicSchedule clinicSchedule) {
        if (clinicSchedule == null) return null;

        ClinicLocation location = clinicSchedule.getClinicLocation();

        return ScheduleResponseDTO.builder()
                .clinicId(clinicSchedule.getClinicId())
                .doctorId(clinicSchedule.getDoctorId() != null
                        ? clinicSchedule.getDoctorId().getDoctorId()
                        : null)
                .street(location != null ? location.getStreet() : null)
                .city(location != null ? location.getCity() : null)
                .province(location != null ? location.getProvince() : null)
                .postalCode(location != null ? location.getPostalCode() : null)
                .clinicStatus(clinicSchedule.getClinicStatus())
                .slotDurationMinutes(clinicSchedule.getSlotDurationMinutes())
                .weeklyTimeRanges(mapWeeklyRanges(clinicSchedule.getWeeklyHours()))
                .timeSlotBlockedList(mapBlockedSlots(clinicSchedule.getBlockedSlots()))
                .build();
    }

    private static List<TimeSlotBlocked> mapBlockedSlots(List<TimeSlotBlocked> slots){
        if(slots == null) return new ArrayList<>();
        return slots.stream()
                .map(t -> new TimeSlotBlocked(t.getBlock_startTime(), t.getBlock_endTime()))
                .collect(Collectors.toList());
    }



//    public static ScheduleResponseDTO toResponseDTO(ClinicSchedule clinicSchedule) {
//        if (clinicSchedule == null) return null;
//
//        return ScheduleResponseDTO.builder()
//                .clinicId(clinicSchedule.getClinicId())
//                .doctorId(clinicSchedule.getDoctorId().getDoctorId())
//                .street(clinicSchedule.getClinicLocation().getStreet())
//                .city(clinicSchedule.getClinicLocation().getCity())
//                .province(clinicSchedule.getClinicLocation().getProvince())
//                .postalCode(clinicSchedule.getClinicLocation().getPostalCode())
//                .clinicStatus(clinicSchedule.getClinicStatus())
//                .slotDurationMinutes(clinicSchedule.getSlotDurationMinutes())
//                .weeklyTimeRanges(mapWeeklyRanges(clinicSchedule.getWeeklyHours()))
//                .timeSlotBlockedList(clinicSchedule.getBlockedSlots())
//                .build();
//    }

    private static List<WeeklyTimeRange> mapWeeklyRanges(List<WeeklyTimeRange> ranges){
        if(ranges == null) return new ArrayList<>();

        return ranges.stream()
                .map(r -> new WeeklyTimeRange(
                        r.getDayOfWeek(),
                        r.getClinic_startTime(),
                        r.getClinic_endTime()))
                .collect(Collectors.toList());
    }


    public static ClinicSchedule toEntity(ScheduleRequestDTO scheduleRequestDTO) {

        List<WeeklyTimeRange> weeklyHours = scheduleRequestDTO.getWeeklyTimeRanges() != null
                ? scheduleRequestDTO.getWeeklyTimeRanges().stream()
                .map(s -> new WeeklyTimeRange(
                        s.getDayOfWeek(),
                        s.getClinic_startTime(),
                        s.getClinic_endTime()))
                .collect(Collectors.toList())
                : new ArrayList<>();


        List<TimeSlotBlocked> blockedSlots = scheduleRequestDTO.getTimeSlotBlockedList() != null
                ? scheduleRequestDTO.getTimeSlotBlockedList().stream()
                .map(t -> new TimeSlotBlocked(
                        t.getBlock_startTime(),
                        t.getBlock_endTime()))
                .collect(Collectors.toList())
                : new ArrayList<>();



        ClinicLocation location = ClinicLocation.builder()
                .street(scheduleRequestDTO.getStreet() != null ? scheduleRequestDTO.getStreet() : null)
                .city(scheduleRequestDTO.getCity() != null ? scheduleRequestDTO.getCity() : null)
                .province(scheduleRequestDTO.getProvince() != null ? scheduleRequestDTO.getProvince() : null)
                .postalCode(scheduleRequestDTO.getPostalCode() != null ? scheduleRequestDTO.getPostalCode() : null)
                .build();

        return ClinicSchedule.builder()
                .doctorId(new DoctorIdentifier(scheduleRequestDTO.getDoctorId()))
                .clinicLocation(location)
                .clinicStatus(scheduleRequestDTO.getClinicStatus())
                .isOpen(false)
                .weeklyHours(weeklyHours)
                .blockedSlots(blockedSlots)
                .slotDurationMinutes(scheduleRequestDTO.getSlotDurationMinutes())
                .build();

//        ClinicLocation location = ClinicLocation.builder()
//                .street(scheduleRequestDTO.getStreet())
//                .city(scheduleRequestDTO.getCity())
//                .province(scheduleRequestDTO.getProvince())
//                .postalCode(scheduleRequestDTO.getPostalCode())
//                .build();

//        return ClinicSchedule.builder()
//                .clinicLocation(location)
//                .weeklyHours(weeklyHours)
//                .blockedSlots(blockedSlot)
//                .slotDurationMinutes(scheduleRequestDTO.getSlotDurationMinutes())
//                .build();
    }

    public static List<ScheduleResponseDTO> toResponseDTOList(List<ClinicSchedule> schedules) {
        return schedules.stream().map(ScheduleMapper::toResponseDTO).collect(Collectors.toList());
    }
}
