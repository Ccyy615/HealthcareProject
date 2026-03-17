package com.champ.healthcare.Appointment.PresentationLayer;

import com.champ.healthcare.Appointment.Domain.AppointmentStatus;
import com.champ.healthcare.Appointment.Domain.TimeSlot;
import com.champ.healthcare.ClinicAvailability.Domain.ClinicSchedule;
import com.champ.healthcare.Doctor.Domain.DoctorIdentifier;
import com.champ.healthcare.Patient.Domain.Patient;
import com.champ.healthcare.Patient.Domain.PatientIdentifier;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentResponseDTO {

    private Long appointmentId;
    private String status;
    private LocalDateTime createdAt;
    private TimeSlot timeSlot;
    private String description;

    private ClinicSchedule clinicId;
    private DoctorIdentifier doctorId;
    private PatientIdentifier patientId;
}
