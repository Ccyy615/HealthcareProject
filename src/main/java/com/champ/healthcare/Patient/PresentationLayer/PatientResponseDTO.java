package com.champ.healthcare.Patient.PresentationLayer;

import com.champ.healthcare.Patient.Domain.BloodType;
import com.champ.healthcare.Patient.Domain.PatientStatus;
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

    private String email;
    private String phone;
    private String address;

    private String insuranceNumber;

    private String allergySubstance;
    private String allergyReaction;

    private BloodType bloodType;
    private PatientStatus status;
}