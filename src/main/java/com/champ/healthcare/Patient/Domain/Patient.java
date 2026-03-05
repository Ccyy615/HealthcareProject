package com.champ.healthcare.Patient.Domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "patients")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private PatientIdentifier patientIdentifier;

    private String fullName;
    private Date dateOfBirth;
    private String gender;
    private ContactInfo contactInfo;
    private String insuranceNumber;
    private Allergy allergy;
    private BloodType bloodType;
    private PatientStatus status;
}
