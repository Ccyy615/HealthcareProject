package com.champ.healthcare.Doctor.Domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DoctorIdentifier {

    @Column(name = "doctor_id", nullable = false, unique = true)
    private String doctorId;

    public DoctorIdentifier(UUID uuid) {
        this.doctorId = uuid.toString();
    }


//    @Column(name = "doctor_id")
//    private String doctorId;
//
//    public  DoctorIdentifier() {
//        this.doctorId = UUID.randomUUID().toString();
//    }

}
