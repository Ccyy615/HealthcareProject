package com.champ.healthcare.Doctor.Domain;


import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WorkZone {
    private String city;
    private String province;
    private Integer maxTravelDistance; // in kilometers

    public void validate() {
        if (city == null || city.trim().isEmpty()) {
            throw new IllegalArgumentException("City is required");
        }
        if (province == null || province.trim().isEmpty()) {
            throw new IllegalArgumentException("Province is required");
        }
        if (maxTravelDistance == null || maxTravelDistance <= 0) {
            throw new IllegalArgumentException("Max travel distance must be positive");
        }
    }
}