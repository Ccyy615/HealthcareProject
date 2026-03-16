package com.champ.healthcare.Appointment.Domain;

import com.champ.healthcare.ClinicAvailability.Domain.ClinicSchedule;
import com.champ.healthcare.Doctor.Domain.DoctorIdentifier;
import com.champ.healthcare.Patient.Domain.PatientIdentifier;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "appointments")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "appointment_id")
    private Long appointmentId;

    @Column(name = "patient_id", columnDefinition = "UUID")
    private UUID patientId;

    @Column(name = "doctor_id", columnDefinition = "UUID")
    private UUID doctorId;

    @ManyToOne
    @JoinColumn(name = "clinic_id")
    private ClinicSchedule clinic;


    @Enumerated(EnumType.STRING)
    @Column(name = "appointment_status", nullable = false)
    private AppointmentStatus status;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="startTime", column=@Column(name="appointment_start")),
            @AttributeOverride(name="endTime", column=@Column(name="appointment_end"))
    })
    private TimeSlot timeSlot;

    @Column(name = "descriptions", length = 5000)
    private String description;

//         /**
//     *******************************
//     *******************************
//     **/


    public void confirmAppointment(ClinicSchedule clinic) {
        if (clinic == null) {
            throw new IllegalArgumentException("Clinic cannot be null");
        }

        if (!clinic.isSlotAvailable(this.timeSlot)) {
            throw new IllegalStateException(
                    "Cannot confirm appointment: time slot is outside clinic hours or blocked"
            );
        }

        this.status = AppointmentStatus.CONFIRMED;
    }


}
