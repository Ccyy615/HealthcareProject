package com.champ.healthcare.Doctor.BusinessLogicLayer;

import com.champ.healthcare.Doctor.DataAccessLayer.DoctorRepository;
import com.champ.healthcare.Doctor.Domain.Doctor;
import com.champ.healthcare.Doctor.Domain.License;
import com.champ.healthcare.Doctor.Domain.Speciality;
import com.champ.healthcare.Doctor.Mapper.DoctorMapper;
import com.champ.healthcare.Doctor.PresentationLayer.DoctorRequestDTO;
import com.champ.healthcare.Doctor.PresentationLayer.DoctorResponseDTO;
import com.champ.healthcare.Doctor.PresentationLayer.LicenseRequestDTO;
import com.champ.healthcare.utilities.DoctorNotEligibleException;
import com.champ.healthcare.utilities.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class DoctorService {

    private final DoctorRepository doctorRepository;
    private final DoctorMapper doctorMapper;

    @Transactional(readOnly = true)
    public List<DoctorResponseDTO> getAllDoctors() {
        log.info("Fetching all doctors");

        return doctorRepository.findAll().stream()
                .map(doctorMapper::toResponseDTO)
                .collect(Collectors.toList());
    }


    @Transactional(readOnly = true)
    public DoctorResponseDTO getDoctorById(String doctorId) {
        log.info("Fetching doctor with ID: {}", doctorId);

        Doctor doctor = doctorRepository
                .findByDoctorIdentifier_DoctorId(doctorId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Doctor not found with ID: " + doctorId));

        return doctorMapper.toResponseDTO(doctor);
    }

    @Transactional
    public DoctorResponseDTO createDoctor(DoctorRequestDTO requestDTO) {

        Doctor doctor = doctorMapper.toEntity(requestDTO);
        log.info("Handyman profile created with ID: {}",
                doctor.getDoctorIdentifier().getDoctorId());

        Doctor savedDoctor = doctorRepository.save(doctor);
        log.info("Doctor saved with ID: {}",
                savedDoctor.getDoctorIdentifier().getDoctorId());
        return doctorMapper.toResponseDTO(savedDoctor);
    }

    @Transactional
    public DoctorResponseDTO updateDoctor(String doctorId, DoctorRequestDTO requestDTO) {
        log.info("Updating doctor with ID: {}", doctorId);

        Doctor doctor = doctorRepository
                .findByDoctorIdentifier_DoctorId(doctorId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Doctor not found with ID: " + doctorId));
        log.info("Doctor found with ID: {}",
                doctor.getDoctorIdentifier().getDoctorId());

        Doctor doctorProfile = doctorMapper.toEntity(requestDTO);
        doctorProfile.setId(doctor.getId()); //keep same id
        Doctor updatedDoctor = doctorRepository.save(doctorProfile);
        return doctorMapper.toResponseDTO(updatedDoctor);
    }


    @Transactional(readOnly = true)
    public List<DoctorResponseDTO> getActiveDoctors() {
        log.info("Fetching active doctor");

        return doctorRepository.findByIsActiveTrue().stream()
                .map(doctorMapper::toResponseDTO)
                .collect(Collectors.toList());
    }


    @Transactional(readOnly = true)
    public List<DoctorResponseDTO> getActiveDoctorBySpeciality(String specialityName) {
        log.info("Fetching active handymen with speciality: {}", specialityName);
        List<Speciality> specialities = new ArrayList<>();
        specialities.add(new Speciality(specialityName, null) );
        return doctorRepository.findActiveDoctorBySpeciality(
                        specialities).stream()
                .map(doctorMapper::toResponseDTO)
                .collect(Collectors.toList());
    }


    @Transactional
    public DoctorResponseDTO activateDoctor(String doctorId) {
        log.info("Activating doctor with ID: {}", doctorId);

        Doctor doctor = doctorRepository
                .findByDoctorIdentifier_DoctorId(doctorId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Doctor not found with ID: " + doctorId));

        try {
            doctor.activate(); // This enforces the invariant
            Doctor saveDoctor = doctorRepository.save(doctor);
            log.info("Doctor activated successfully: {}", doctorId);
            return doctorMapper.toResponseDTO(saveDoctor);
        } catch (DoctorNotEligibleException e) {
            log.error("Failed to activate doctor {}: {}", doctorId, e.getMessage());
            throw e;
        }
    }

    @Transactional
    public DoctorResponseDTO deactivateDoctor(String doctorId) {
        log.info("Deactivating doctor with ID: {}", doctorId);

        Doctor doctor = doctorRepository
                .findByDoctorIdentifier_DoctorId(doctorId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Doctor not found with ID: " + doctorId));

        doctor.deactivate();
        Doctor savedDoctor = doctorRepository.save(doctor);

        log.info("Doctor deactivated successfully: {}", doctorId);
        return doctorMapper.toResponseDTO(savedDoctor);
    }

    @Transactional
    public DoctorResponseDTO addSpeciality(String doctorId, Speciality specialityDTO) {
        log.info("Adding skill {} to handyman {}", specialityDTO.getSpeciality(), doctorId);

        Doctor doctor = doctorRepository
                .findByDoctorIdentifier_DoctorId(doctorId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Doctor not found with ID: " + doctorId));

        Speciality speciality = new Speciality(specialityDTO.getSpeciality(), specialityDTO.getProficiencyLevel());
        doctor.addSpeciality(speciality);

        Doctor savedDoctor = doctorRepository.save(doctor);
        return doctorMapper.toResponseDTO(savedDoctor);
    }

    @Transactional
    public DoctorResponseDTO removeSpeciality(String doctorId, String specialityName) {
        log.info("Removing skill {} from handyman {}", specialityName, doctorId);

        Doctor doctor = doctorRepository
                .findByDoctorIdentifier_DoctorId(doctorId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Doctor not found with ID: " + doctorId));

        doctor.removeSpeciality(specialityName);

        Doctor savedDoctor = doctorRepository.save(doctor);
        return doctorMapper.toResponseDTO(savedDoctor);
    }

    @Transactional
    public DoctorResponseDTO addLicense(String doctorId, LicenseRequestDTO requestDTO) {
        log.info("Add a license for doctor {}", doctorId);

        Doctor doctor = doctorRepository
                .findByDoctorIdentifier_DoctorId(doctorId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Doctor not found with ID: " + doctorId));

        License license = new License(
                requestDTO.getLicenseName(),
                requestDTO.getStatus(),
                LocalDateTime.now()
        );

        doctor.setLicense(license);

        Doctor sacedDoctor = doctorRepository.save(doctor);
        return doctorMapper.toResponseDTO(sacedDoctor);
    }

    @Transactional
    public void deleteDoctor(String doctorId) {
        log.info("Deleting doctor with ID: {}", doctorId);

        Doctor doctor = doctorRepository
                .findByDoctorIdentifier_DoctorId(doctorId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Doctor not found with ID: " + doctorId));

        doctorRepository.delete(doctor);
        log.info("Doctor deleted successfully: {}", doctorId);
    }


}
