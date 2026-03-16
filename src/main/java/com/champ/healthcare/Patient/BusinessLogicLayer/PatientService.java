package com.champ.healthcare.Patient.BusinessLogicLayer;

import com.champ.healthcare.Patient.PresentationLayer.PatientRequestDTO;
import com.champ.healthcare.Patient.PresentationLayer.PatientResponseDTO;

import java.util.List;
import java.util.UUID;

public interface PatientService {

    List<PatientResponseDTO> getAllPatients();

    PatientResponseDTO getPatientById(UUID id);

    PatientResponseDTO createPatient(PatientRequestDTO patientRequestDTO);

    PatientResponseDTO updatePatient(UUID id, PatientRequestDTO patientRequestDTO);

    PatientResponseDTO deletePatientById(UUID id);
}