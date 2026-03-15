package com.champ.healthcare.Patient.Mapper;

import com.champ.healthcare.Patient.Domain.*;
import com.champ.healthcare.Patient.PresentationLayer.PatientRequestDTO;
import com.champ.healthcare.Patient.PresentationLayer.PatientResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class PatientMapper {

    public Patient toEntity(PatientRequestDTO patientRequestDTO) {

        Address address = new Address(
                patientRequestDTO.getContactInfo().getAddress().getStreet(),
                patientRequestDTO.getContactInfo().getAddress().getCity(),
                patientRequestDTO.getContactInfo().getAddress().getPostal_code(),
                patientRequestDTO.getContactInfo().getAddress().getProvince(),
                patientRequestDTO.getContactInfo().getAddress().getCountry()
        );

        ContactInfo contactInfo = new ContactInfo(
                patientRequestDTO.getContactInfo().getEmail(),
                patientRequestDTO.getContactInfo().getPhone(),
                address
        );

        Allergy allergy = new Allergy(
                patientRequestDTO.getAllergy().getSubstance(),
                patientRequestDTO.getAllergy().getReaction()
        );

        return Patient.builder()
                .patientId(new PatientIdentifier())
                .fullName(patientRequestDTO.getFullName())
                .dateOfBirth(patientRequestDTO.getDateOfBirth())
                .gender(patientRequestDTO.getGender())
                .contactInfo(contactInfo)
                .insuranceNumber(patientRequestDTO.getInsuranceNumber())
                .allergy(allergy)
                .bloodType(patientRequestDTO.getBloodType())
                .status(patientRequestDTO.getStatus())
                .build();

    }

    public PatientResponseDTO  toResponseDTO(Patient patient) {
        PatientResponseDTO patientResponseDTO = new PatientResponseDTO();
        patientResponseDTO.setPatientId(patient.getPatientId().getPatientId());
        patientResponseDTO.setFullName(patient.getFullName());
        patientResponseDTO.setDateOfBirth(patient.getDateOfBirth());
        patientResponseDTO.setGender(patient.getGender());
        patientResponseDTO.setContactInfo(patient.getContactInfo());
        patientResponseDTO.setInsuranceNumber(patient.getInsuranceNumber());
        patientResponseDTO.setAllergy(patient.getAllergy());
        patientResponseDTO.setBloodType(patient.getBloodType());
        patientResponseDTO.setStatus(patient.getStatus());

        return patientResponseDTO;
    }

}
