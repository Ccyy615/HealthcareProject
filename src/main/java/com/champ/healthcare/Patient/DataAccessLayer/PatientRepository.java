package com.champ.healthcare.Patient.DataAccessLayer;

import com.champ.healthcare.Patient.Domain.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PatientRepository extends JpaRepository<Patient, UUID> {
}
