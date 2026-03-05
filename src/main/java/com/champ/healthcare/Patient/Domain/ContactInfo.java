package com.champ.healthcare.Patient.Domain;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Embeddable
public class ContactInfo {

    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private Address address;
}
