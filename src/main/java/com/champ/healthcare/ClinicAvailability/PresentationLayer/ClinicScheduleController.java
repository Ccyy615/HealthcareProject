package com.champ.healthcare.ClinicAvailability.PresentationLayer;

import com.champ.healthcare.ClinicAvailability.BusinessLogicLayer.*;
import com.champ.healthcare.ClinicAvailability.Mapper.ScheduleMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/clinic_schedules")
@RequiredArgsConstructor
public class ClinicScheduleController {

    private final ScheduleService clinicScheduleService;
    @GetMapping
    public ResponseEntity<List<ScheduleResponseDTO>> getAllSchedules(){
        return ResponseEntity.ok(clinicScheduleService.getAllSchedules());
    }

    @GetMapping("/{clinicId}")
    public ResponseEntity<ScheduleResponseDTO> getScheduleById(@PathVariable Long clinicId) {
        return ResponseEntity.ok(clinicScheduleService.getScheduleById(clinicId));
    }

    @PostMapping
    public ResponseEntity<ScheduleResponseDTO> createSchedule(@RequestBody ScheduleRequestDTO scheduleRequestDTO) {
        return ResponseEntity.ok(clinicScheduleService.createSchedule(scheduleRequestDTO));
    }

    @PutMapping("/{clinicId}")
    public ResponseEntity<ScheduleResponseDTO> updateSchedule(@PathVariable Long clinicId,
                                                              @RequestBody ScheduleRequestDTO scheduleRequestDTO){
        return ResponseEntity.ok(clinicScheduleService.updateSchedule(clinicId, scheduleRequestDTO));
    }

    @DeleteMapping("/{clinicId}")
    public ResponseEntity<ScheduleResponseDTO> deleteSchedule(@PathVariable Long clinicId){
        return ResponseEntity.ok(clinicScheduleService.deleteSchedule(clinicId));
    }
}
