package com.champ.healthcare.Doctor.PresentationLayer;

import com.champ.healthcare.Doctor.Domain.LicenseStatus;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class LicenseRequestDTO {

    private String licenseName;

    @NotNull(message = "Ststus is requires")
    private LicenseStatus status;
}
