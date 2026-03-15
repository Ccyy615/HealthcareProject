package com.champ.healthcare.Patient.Domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContactInfo {

    @NotBlank(message = "Email is required")
    @Email(message = "Email must be valid")
    private String email;

    private PhoneType phone;

    @Embedded
    private Address address;
}