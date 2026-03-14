package com.champ.healthcare.Doctor.Mapper;

import com.champ.healthcare.Doctor.Domain.Doctor;
import com.champ.healthcare.Doctor.Domain.*;
import com.champ.healthcare.Doctor.PresentationLayer.*;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class DoctorMapper {

    public Doctor toEntity(DoctorRequestDTO doctorRequestDTO) {
        WorkZone workZone = new WorkZone(
                doctorRequestDTO.getWorkZone().getCity(),
                doctorRequestDTO.getWorkZone().getProvince(),
                doctorRequestDTO.getWorkZone().getMaxTravelDistance()
        );

        var speciality = doctorRequestDTO.getSpeciality() != null
                ? doctorRequestDTO.getSpeciality().stream()
                .map(s -> new Speciality(s.getSpeciality(), s.getProficiencyLevel()))
                .collect(Collectors.toList())
                : null;

        return Doctor.builder()
                .doctorIdentifier(new DoctorIdentifier())
                .doctorFirstName(doctorRequestDTO.getDoctorFirstName())
                .doctorLastName(doctorRequestDTO.getDoctorLastName())
                .workZone(workZone)
                .speciality(speciality)
                .build();

    }

    public DoctorResponseDTO toResponseDTO (Doctor entity) {
        DoctorResponseDTO doctorResponseDTO = new DoctorResponseDTO();
        doctorResponseDTO.setDoctorId(entity.getDoctorIdentifier().getDoctorId());
        doctorResponseDTO.setDoctorFirstName(entity.getDoctorFirstName());
        doctorResponseDTO.setDoctorLastName(entity.getDoctorLastName());
        doctorResponseDTO.setIsActive(entity.getIsActive());
        doctorResponseDTO.setIsValid(entity.getIsValid());

        if (entity.getWorkZone() != null) {
            WorkZone workZoneDTO = new WorkZone();
            workZoneDTO.setCity(entity.getWorkZone().getCity());
            workZoneDTO.setProvince(entity.getWorkZone().getProvince());
            workZoneDTO.setMaxTravelDistance(entity.getWorkZone().getMaxTravelDistance());
            doctorResponseDTO.setWorkZone(workZoneDTO);
        }

        if (entity.getSpeciality() != null) {
            var specialityDTO = entity.getSpeciality().stream()
                    .map(s -> {
                        Speciality speciality = new Speciality();
                        speciality.setSpeciality(s.getSpeciality());
                        speciality.setProficiencyLevel(s.getProficiencyLevel());
                        return speciality;
                    })
                    .collect(Collectors.toList());
            doctorResponseDTO.setSpeciality(specialityDTO);
        }

        return doctorResponseDTO;
    }
}
