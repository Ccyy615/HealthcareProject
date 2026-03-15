package com.champ.healthcare.Patient.BusinessLogicLayer;

import com.champ.healthcare.Patient.DataAccessLayer.PatientRepository;
import com.champ.healthcare.Patient.Domain.Allergy;
import com.champ.healthcare.Patient.Domain.ContactInfo;
import com.champ.healthcare.Patient.Domain.Patient;
import com.champ.healthcare.Patient.PresentationLayer.PatientRequestDTO;
import com.champ.healthcare.Patient.PresentationLayer.PatientResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;

    @Override
    public List<PatientResponseDTO> getAllPatients() {
        return patientRepository.findAll()
                .stream()
                .map(this::toResponseDTO)
                .toList();
    }

    @Override
    public PatientResponseDTO getPatientById(Long id) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found with id: " + id));

        return toResponseDTO(patient);
    }

    @Override
    public PatientResponseDTO createPatient(PatientRequestDTO patientRequestDTO) {
        ContactInfo contactInfo = new ContactInfo(
                patientRequestDTO.getEmail(),
                patientRequestDTO.getPhone(),
                patientRequestDTO.getAddress()
        );

        Allergy allergy = new Allergy(
                patientRequestDTO.getAllergySubstance(),
                patientRequestDTO.getAllergyReaction()
        );

        Patient patient = new Patient(
                patientRequestDTO.getFullName(),
                patientRequestDTO.getDateOfBirth(),
                patientRequestDTO.getGender(),
                contactInfo,
                patientRequestDTO.getInsuranceNumber(),
                allergy,
                patientRequestDTO.getBloodType(),
                patientRequestDTO.getStatus()
        );

        Patient savedPatient = patientRepository.save(patient);
        return toResponseDTO(savedPatient);
    }

    private PatientResponseDTO toResponseDTO(Patient patient) {
        return new PatientResponseDTO(
                patient.getId(),
                patient.getPatientId().getPatientId(),
                patient.getFullName(),
                patient.getDateOfBirth(),
                patient.getGender(),
                patient.getContactInfo().getEmail(),
                patient.getContactInfo().getPhone(),
                patient.getContactInfo().getAddress(),
                patient.getInsuranceNumber(),
                patient.getAllergy().getSubstance(),
                patient.getAllergy().getReaction(),
                patient.getBloodType(),
                patient.getStatus()
        );
    }
}