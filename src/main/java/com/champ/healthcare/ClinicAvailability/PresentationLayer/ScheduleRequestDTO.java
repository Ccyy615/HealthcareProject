package com.champ.healthcare.ClinicAvailability.PresentationLayer;

import com.champ.healthcare.ClinicAvailability.Domain.ClinicLocation;
import com.champ.healthcare.ClinicAvailability.Domain.ClinicStatus;
import com.champ.healthcare.ClinicAvailability.Domain.TimeSlotBlocked;
import com.champ.healthcare.ClinicAvailability.Domain.WeeklyTimeRange;
import lombok.*;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleRequestDTO {

    private String doctorId;
    // Clinic Location
    private String street;
    private String city;
    private String province;
    private String postalCode;

    private ClinicStatus clinicStatus;

    private List<WeeklyTimeRange> weeklyTimeRanges;
    private List<TimeSlotBlocked> timeSlotBlockedList;

    private Integer slotDurationMinutes;

}
