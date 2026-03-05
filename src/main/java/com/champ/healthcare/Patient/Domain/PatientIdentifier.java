package com.champ.healthcare.Patient.Domain;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
public class PatientIdentifier {

    private String patientId;

    public  PatientIdentifier() {
        this.patientId = UUID.randomUUID().toString();
    }

}
