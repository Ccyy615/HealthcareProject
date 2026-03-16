package com.champ.healthcare.Patient.Domain;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Embeddable
@Getter
public class PatientIdentifier {

    private String patientId;

    //public PatientIdentifier(String patientId) {
    //    this.patientId = patientId;
    //}

    public PatientIdentifier() {
        this.patientId = UUID.randomUUID().toString();
    }
}