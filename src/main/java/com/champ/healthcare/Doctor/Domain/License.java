package com.champ.healthcare.Doctor.Domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "doctor_license")
@Getter
@Setter
@NoArgsConstructor
public class License {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID licenseId;

    @Column(nullable = false)
    private String licenseName;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private LicenseStatus status;

    @Column(nullable = false)
    private LocalDateTime performedDate;

    private LocalDateTime expiryDate;


    @OneToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    public License(String licenseName,LicenseStatus status, LocalDateTime performedDate) {
        this.licenseName = licenseName;
        this.status = status;
        this.performedDate = performedDate;

        if (status == LicenseStatus.VALID) {
            this.expiryDate = performedDate.plusYears(5);
        }
    }

    public void updateStatus(String licenseName,LicenseStatus newStatus) {
        this.licenseName = licenseName;
        this.status = newStatus;
        if (newStatus == LicenseStatus.VALID) {
            this.expiryDate = LocalDateTime.now().plusYears(5);
        }
    }

    public boolean isValid() {
        return status == LicenseStatus.VALID
                && (expiryDate == null || expiryDate.isAfter(LocalDateTime.now()));
    }

    public boolean isExpired() {
        return expiryDate != null && expiryDate.isBefore(LocalDateTime.now());
    }



}
