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

    @Column(nullable = false)
    private String patientFirstName;

    @Column(nullable = false)
    private String patientLastName;

    @Column(nullable = false)
    private Date dateOfBirth;

    @Column(nullable = false)
    private String gender;

    @Column(nullable = false)
    private ContactInfo contactInfo;

    @Column(nullable = false)
    private String insuranceNumber;

    @Column(nullable = false)
    private Allergy allergy;

    @Column(nullable = false)
    private BloodType bloodType;

    private PatientStatus status;
}
