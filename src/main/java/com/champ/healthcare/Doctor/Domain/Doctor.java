package com.champ.healthcare.Doctor.Domain;

import com.champ.healthcare.utilities.DoctorNotEligibleException;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "doctors")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private DoctorIdentifier doctorIdentifier;

    @Column(nullable = false)
    private String doctorFirstName;

    @Column(nullable = false)
    private String doctorLastName;

    @Column(nullable = false)
    private Boolean isActive;

    @Column(nullable = false)
    private Boolean isValid;

    @Column(nullable = false)
    private String licenseNumber;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "city", column = @Column(name = "work_zone_city")),
            @AttributeOverride(name = "province", column = @Column(name = "work_zone_province")),
            @AttributeOverride(name = "maxTravelDistance", column = @Column(name = "max_travel_distance"))
    })
    private WorkZone workZone;
    @ElementCollection
    @CollectionTable(name = "doctor_specialities", joinColumns = @JoinColumn(name = "doctor_fk"))
    private List<Speciality> speciality;


//    /**
//     * Invariant
//     *
//     */

    public void activate() {

        if (!hasVerifiedSkill()) {
            throw new DoctorNotEligibleException(
                    "Cannot activate Doctor: No verified speciality found. "
            );
        }
        this.isActive = true;
    }

    public void deactivate() {
        this.isActive = false;
    }

    public void verify() {
        this.isValid = true;
    }

    public void unverify() {
        this.isValid = false;
        this.isActive = false; // If unverified, must also be inactive
    }

    public void addSpeciality(Speciality specialitySet) {
        specialitySet.validate();
        this.speciality.add(specialitySet);
    }

    public void removeSpeciality(String specialityName) {
        this.speciality.removeIf(speciality -> speciality.getSpeciality().equalsIgnoreCase(specialityName));

        if (this.isActive && !hasVerifiedSkill()) {
            this.isActive = false;
        }
    }

    public void updateWorkZone(WorkZone newWorkZone) {
        newWorkZone.validate();
        this.workZone = newWorkZone;
    }

    private boolean hasVerifiedSkill() {
        return speciality.stream().anyMatch(Speciality::isVerified);
    }






}
