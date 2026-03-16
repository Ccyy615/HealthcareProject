package com.champ.healthcare.ClinicAvailability.Domain;

import jakarta.persistence.*;
import lombok.*;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor(force = true)
@Getter
@Setter
@EqualsAndHashCode
@Builder
public class ClinicLocation {

    @Column(name = "clinic_location_street", nullable = false)
    private String street;

    @Column(name = "clinic_location_city", nullable = false)
    private String city;

    @Column(name = "clinic_location_province")
    private String province;

    @Column(name = "clinic_location_postalcode")
    private String postalCode;


}
