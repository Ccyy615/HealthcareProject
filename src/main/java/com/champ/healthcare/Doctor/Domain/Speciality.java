package com.champ.healthcare.Doctor.Domain;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
public class Speciality {
    private String speciality;

    public Speciality() {
        this.speciality = "";
    }
}
