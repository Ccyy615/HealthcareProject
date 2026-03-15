package com.champ.healthcare.ClinicAvailability.DataAccessLayer;

import com.champ.healthcare.ClinicAvailability.Domain.ClinicSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClinicScheduleRepository extends JpaRepository <ClinicSchedule, Long>{

    Optional<ClinicSchedule> findByClinicId(Long clinicId);
}

