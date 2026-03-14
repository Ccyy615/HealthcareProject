package com.champ.healthcare.Doctor.PresentationLayer;

import lombok.*;

import java.time.LocalTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DoctorResponseDTO {


    private UUID doctorId;
    private String doctor_FullName;
    private boolean doctor_IsActive;
    private LocalTime doctor_StartTime;
}
