package com.champ.healthcare.ClinicAvailability.PresentationLayer;

import com.champ.healthcare.ClinicAvailability.Domain.*;
import lombok.*;

import java.time.*;
import java.util.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleResponseDTO {

    private Long clinicId;
    private String doctorId;

    // Clinic
    private String street;
    private String city;
    private String province;
    private String postalCode;

    private ClinicStatus clinicStatus;

    private Integer slotDurationMinutes;
    private List<WeeklyTimeRange> weeklyTimeRanges;
    private List<TimeSlotBlocked> timeSlotBlockedList;
}
