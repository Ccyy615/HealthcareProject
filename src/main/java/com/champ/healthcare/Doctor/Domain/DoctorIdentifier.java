package com.champ.healthcare.Doctor.Domain;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
public class DoctorIdentifier {

    private String doctorId;

    public  DoctorIdentifier() {
        this.doctorId = UUID.randomUUID().toString();
    }

}
