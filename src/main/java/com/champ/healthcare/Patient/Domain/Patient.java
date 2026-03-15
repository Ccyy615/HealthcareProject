package com.champ.healthcare.Patient.Domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "patients")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private PatientIdentifier patientId;

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false)
    private LocalDate dateOfBirth;

    @Column(nullable = false)
    private String gender;

    @Embedded
    private ContactInfo contactInfo;

    @Column(nullable = false)
    private String insuranceNumber;

    @Embedded
    private Allergy allergy;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BloodType bloodType;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PatientStatus status;

    public Patient(
            String fullName,
            LocalDate dateOfBirth,
            String gender,
            ContactInfo contactInfo,
            String insuranceNumber,
            Allergy allergy,
            BloodType bloodType,
            PatientStatus status
    ) {
        validateContactInfo(contactInfo);

        this.patientId = new PatientIdentifier();
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.contactInfo = contactInfo;
        this.insuranceNumber = insuranceNumber;
        this.allergy = allergy;
        this.bloodType = bloodType;
        this.status = status;
    }

    public void updateContactInfo(ContactInfo newContactInfo) {
        validateContactInfo(newContactInfo);
        this.contactInfo = newContactInfo;
    }

    public void deactivate() {
        this.status = PatientStatus.INACTIVE;
    }

    public void activate() {
        this.status = PatientStatus.ACTIVE;
    }


    public void updateEmail(String newEmail) {
        validateEmail(newEmail); // still validates the string
        if (this.contactInfo == null) {
            this.contactInfo = new ContactInfo(); // create ContactInfo if it’s null
        }
        this.contactInfo.setEmail(newEmail); // update the email inside ContactInfo
    }


    private void validateContactInfo(ContactInfo contactInfo) {
        boolean hasEmail = contactInfo.getEmail() != null && !contactInfo.getEmail().isBlank();
        boolean hasPhone = contactInfo.getPhone() != null && !contactInfo.getPhone().isBlank();

        if (!hasEmail && !hasPhone) {
            throw new IllegalArgumentException(
                    "Patient must have at least one valid contact method: email or phone."
            );
        }
    }

    private void validateEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("Email is required");
        }
        if (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {
            throw new IllegalArgumentException("Invalid email format");
        }
    }

}