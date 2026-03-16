package com.champ.healthcare.Doctor.PresentationLayer;

import com.champ.healthcare.Doctor.BusinessLogicLayer.DoctorService;
import com.champ.healthcare.Doctor.Domain.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/doctors")
@RequiredArgsConstructor
public class DoctorController {

    private final DoctorService doctorService;

    @GetMapping
    public ResponseEntity<List<DoctorResponseDTO>> getAllDoctors() {
        List<DoctorResponseDTO> responseDTOS = doctorService.getAllDoctors();
        return ResponseEntity.ok(responseDTOS);
    }

    @GetMapping("/{doctorId}")
    public ResponseEntity<DoctorResponseDTO> getDoctorById(@PathVariable UUID doctorId) {
        DoctorResponseDTO response = doctorService.getDoctorById(doctorId);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<DoctorResponseDTO> createDoctor(
            @Valid @RequestBody DoctorRequestDTO doctorRequestDTO) {
        DoctorResponseDTO response = doctorService.createDoctor(doctorRequestDTO);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{doctorId}")
    public ResponseEntity<DoctorResponseDTO> updateDoctor(
            @PathVariable UUID doctorId,
            @Valid @RequestBody DoctorRequestDTO doctorRequestDTO){
        DoctorResponseDTO response = doctorService.updateDoctor(doctorId, doctorRequestDTO);
        return ResponseEntity.ok(response);
    }

    ////////////

    @GetMapping("/active")
    public ResponseEntity<List<DoctorResponseDTO>> getActiveDoctors() {
        List<DoctorResponseDTO> response = doctorService.getActiveDoctors();
        return ResponseEntity.ok(response);
    }


    @GetMapping("/active/speciality/{specialityName}")
    public ResponseEntity<List<DoctorResponseDTO>> getActiveDoctorBySpeciality(
            @PathVariable String specialityName) {
        List<DoctorResponseDTO> response = doctorService.getActiveDoctorBySpeciality(specialityName);
        return ResponseEntity.ok(response);
    }


    @PostMapping("/{doctorId}/activate")
    public ResponseEntity<DoctorResponseDTO> activateDoctor(
            @PathVariable UUID doctorId) {
        DoctorResponseDTO response = doctorService.activateDoctor(doctorId);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/{doctorId}/deactivate")
    public ResponseEntity<DoctorResponseDTO> deactivateDoctor(
            @PathVariable UUID doctorId) {
        DoctorResponseDTO response = doctorService.deactivateDoctor(doctorId);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/{doctorId}/speciality")
    public ResponseEntity<DoctorResponseDTO> addSpeciality(
            @PathVariable UUID doctorId,
            @Valid @RequestBody Speciality specialityDTO) {
        DoctorResponseDTO response = doctorService.addSpeciality(doctorId, specialityDTO);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{doctorId}/speciality/{specialityName}")
    public ResponseEntity<DoctorResponseDTO> removeSpeciality(
            @PathVariable UUID doctorId,
            @PathVariable String specialityName) {
        DoctorResponseDTO response = doctorService.removeSpeciality(doctorId, specialityName);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/{doctorId}/license")
    public ResponseEntity<DoctorResponseDTO> addLicense(
            @PathVariable UUID doctorId,
            @Valid @RequestBody LicenseRequestDTO requestDTO) {
        DoctorResponseDTO response = doctorService.addLicense(doctorId, requestDTO);
        return ResponseEntity.ok(response);
    }


    @DeleteMapping("/{handymanId}")
    public ResponseEntity<Void> deleteDoctor(@PathVariable UUID doctorId) {
        doctorService.deleteDoctor(doctorId);
        return ResponseEntity.noContent().build();
    }
}
