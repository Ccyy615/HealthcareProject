package com.champ.healthcare.Patient.BusinessLogicLayer;

import com.champ.healthcare.Patient.DataAccessLayer.PatientRepository;
import com.champ.healthcare.Patient.Domain.Allergy;
import com.champ.healthcare.Patient.Domain.ContactInfo;
import com.champ.healthcare.Patient.Domain.Patient;
import com.champ.healthcare.Patient.Mapper.PatientMapper;
import com.champ.healthcare.Patient.PresentationLayer.PatientRequestDTO;
import com.champ.healthcare.Patient.PresentationLayer.PatientResponseDTO;
import com.champ.healthcare.utilities.DuplicateEmailException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;
    private final PatientMapper patientMapper;

    @Override
    @Transactional(readOnly = true)
    public List<PatientResponseDTO> getAllPatients() {
        return patientRepository.findAll()
                .stream()
                .map(patientMapper::toResponseDTO)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public PatientResponseDTO getPatientById(Long id) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found with id: " + id));

        return patientMapper.toResponseDTO(patient);
    }

    @Override
    @Transactional(readOnly = true)
    public PatientResponseDTO createPatient(PatientRequestDTO patientRequestDTO) {
        log.info("Creating patient for email: {}", patientRequestDTO.getContactInfo().getEmail());

        if (patientRepository.existsByContactInfoEmail(patientRequestDTO.getContactInfo().getEmail())) {
            throw new DuplicateEmailException("Email already exists: " + patientRequestDTO.getContactInfo().getEmail());
        }
        Patient patient = patientMapper.toEntity(patientRequestDTO);
        Patient savedPatient = patientRepository.save(patient);
        return patientMapper.toResponseDTO(savedPatient);

    }

    @Override
    @Transactional
    public PatientResponseDTO updatePatient(Long id, PatientRequestDTO patientRequestDTO) {
        log.info("Updating patient for id: {}", id);
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found with id: " + id));

        if (!patient.getContactInfo().getEmail().equals(patientRequestDTO.getContactInfo().getEmail())) {
            if (patientRepository.existsByContactInfoEmail(patientRequestDTO.getContactInfo().getEmail())) {
                throw new DuplicateEmailException("Email already exists: " + patientRequestDTO.getContactInfo().getEmail());
            }
            patient.updateEmail(patientRequestDTO.getContactInfo().getEmail());
        }

        Patient patientProfile = patientMapper.toEntity(patientRequestDTO);
        patientProfile.setId(patient.getId());
        Patient updatedPatient = patientRepository.save(patientProfile);
        return patientMapper.toResponseDTO(updatedPatient);
    }

    @Override
    @Transactional
    public PatientResponseDTO deletePatientById(Long id) {
        log.info("Deleting patient for id: {}", id);
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found with id: " + id));

        patientRepository.delete(patient);
        return patientMapper.toResponseDTO(patient);
    }

//    private PatientResponseDTO toResponseDTO(Patient patient) {
//        return new PatientResponseDTO(
//                patient.getId(),
//                patient.getPatientId().getPatientId(),
//                patient.getFullName(),
//                patient.getDateOfBirth(),
//                patient.getGender(),
//                patient.getContactInfo().getEmail(),
//                patient.getContactInfo().getPhone(),
//                patient.getContactInfo().getAddress(),
//                patient.getInsuranceNumber(),
//                patient.getAllergy().getSubstance(),
//                patient.getAllergy().getReaction(),
//                patient.getBloodType(),
//                patient.getStatus()
//        );
//    }
}