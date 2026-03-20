package com.champ.healthcare.Patient.DataAccessLayer;

import com.champ.healthcare.Patient.Domain.Patient;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PatientRepository extends JpaRepository<Patient, Long> {
    boolean existsByContactInfoEmail(String email);
}