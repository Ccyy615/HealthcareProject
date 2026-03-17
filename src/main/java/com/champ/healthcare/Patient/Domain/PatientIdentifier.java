package com.champ.healthcare.Patient.Domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Embeddable
@Getter
public class PatientIdentifier {

    @Column(name = "patient_id", nullable = false, unique = true)
    private String patientId;

    public PatientIdentifier() {
        this.patientId = UUID.randomUUID().toString();
    }

    public String getValue() {
        return patientId;
    }

//    @Column(name = "patient_id")
//    private String patientId;
//
//    //public PatientIdentifier(String patientId) {
//    //    this.patientId = patientId;
//    //}
//
//    public PatientIdentifier() {
//        this.patientId = UUID.randomUUID().toString();
//    }


}