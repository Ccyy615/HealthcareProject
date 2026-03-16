package com.champ.healthcare.Appointment.DataAccessLayer;

import com.champ.healthcare.Appointment.Domain.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    Optional<Appointment> findByAppointmentId(Long appointmentId);
}
