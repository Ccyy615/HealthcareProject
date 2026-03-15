package com.champ.healthcare.Patient.PresentationLayer;

import com.champ.healthcare.Patient.Domain.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientResponseDTO {

    private Long id;
    private String patientId;

    private String fullName;
    private LocalDate dateOfBirth;
    private String gender;

    private ContactInfo contactInfo;

    private String insuranceNumber;

    private Allergy allergy;

    private BloodType bloodType;
    private PatientStatus status;
}