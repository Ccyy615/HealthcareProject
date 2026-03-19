package com.champ.healthcare.Appointment.DataAccessLayer;

import com.champ.healthcare.Appointment.Domain.Appointment;
import com.champ.healthcare.Doctor.Domain.DoctorIdentifier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.*;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    Optional<Appointment> findByAppointmentId(Long appointmentId);


   // List<Appointment> findByClinic_DoctorId(DoctorIdentifier doctorId);

}
