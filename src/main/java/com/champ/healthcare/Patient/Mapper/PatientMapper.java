package com.champ.healthcare.Patient.Mapper;

import com.champ.healthcare.Patient.Domain.*;
import com.champ.healthcare.Patient.PresentationLayer.PatientRequestDTO;
import com.champ.healthcare.Patient.PresentationLayer.PatientResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class PatientMapper {

    public Patient toEntity(PatientRequestDTO patientRequestDTO) {

        Address address = new Address(
                patientRequestDTO.getAddress().getStreet(),
                patientRequestDTO.getAddress().getCity(),
                patientRequestDTO.getAddress().getPostal_code(),
                patientRequestDTO.getAddress().getProvince(),
                patientRequestDTO.getAddress().getCountry()
        );

        ContactInfo contactInfo = new ContactInfo(
                patientRequestDTO.getContactInfo().getEmail(),
                patientRequestDTO.getContactInfo().getPhone()
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
                .address(address)
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
        patientResponseDTO.setAddress(patient.getAddress());
        patientResponseDTO.setInsuranceNumber(patient.getInsuranceNumber());
        patientResponseDTO.setAllergy(patient.getAllergy());
        patientResponseDTO.setBloodType(patient.getBloodType());
        patientResponseDTO.setStatus(patient.getStatus());

        return patientResponseDTO;
    }

}
