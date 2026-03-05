package com.champ.healthcare.Doctor.Domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "doctors")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private DoctorIdentifier doctorIdentifier; // Domain identity (UUID)

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private Boolean isActive;

    @Column(nullable = false)
    private Boolean isValid;

    private String licenseNumber;
    private Speciality speciality;

}
