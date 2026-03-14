package com.champ.healthcare.Doctor.PresentationLayer;

import com.champ.healthcare.Doctor.Domain.DoctorIdentifier;
import lombok.*;

import java.time.LocalTime;
import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DoctorRequestDTO {

    private UUID doctorId;
    private String doctor_FullName;
    private boolean doctor_IsActive;
    private LocalTime doctor_StartTime;
}
