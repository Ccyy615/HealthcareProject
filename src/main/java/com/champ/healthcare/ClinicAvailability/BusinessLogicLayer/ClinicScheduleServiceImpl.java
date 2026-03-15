package com.champ.healthcare.ClinicAvailability.BusinessLogicLayer;

import com.champ.healthcare.ClinicAvailability.DataAccessLayer.ClinicScheduleRepository;
import com.champ.healthcare.ClinicAvailability.Domain.ClinicLocation;
import com.champ.healthcare.ClinicAvailability.Domain.ClinicSchedule;
import com.champ.healthcare.ClinicAvailability.Mapper.ScheduleMapper;
import com.champ.healthcare.ClinicAvailability.PresentationLayer.ScheduleRequestDTO;
import com.champ.healthcare.ClinicAvailability.PresentationLayer.ScheduleResponseDTO;
import com.champ.healthcare.utilities.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ClinicScheduleServiceImpl implements ScheduleService {

    private final ClinicScheduleRepository clinicScheduleRepository;

    @Override
    @Transactional(readOnly = true)
    public List<ScheduleResponseDTO> getAllSchedules(){
        return ScheduleMapper.toResponseDTOList(clinicScheduleRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public ScheduleResponseDTO getScheduleById(Long clinicId) {
        ClinicSchedule schedule = clinicScheduleRepository
                .findByClinicId(clinicId)
                .orElseThrow(() -> new RuntimeException("Schedule not found"));

        ;
        return ScheduleMapper.toResponseDTO(schedule);
    }

    @Override
    @Transactional
    public ScheduleResponseDTO createSchedule(ScheduleRequestDTO scheduleRequestDTO) {
        ClinicSchedule schedule = ScheduleMapper.toEntity(scheduleRequestDTO);
        ClinicSchedule savedSchedule = clinicScheduleRepository.save(schedule);
        log.info("Schedule created: {}", savedSchedule.getClinicId());
        return ScheduleMapper.toResponseDTO(savedSchedule);
    }

    @Override
    @Transactional
    public ScheduleResponseDTO updateSchedule(Long clinicId, ScheduleRequestDTO scheduleRequestDTO){
        ClinicSchedule existingSchedule = clinicScheduleRepository
                .findByClinicId(clinicId)
                .orElseThrow(() -> new RuntimeException("Clinic not found, there is no schedule"));

        existingSchedule.setSlotDurationMinutes(scheduleRequestDTO.getSlotDurationMinutes());
        existingSchedule.setWeeklyHours(scheduleRequestDTO.getWeeklyTimeRanges());
        existingSchedule.setBlockedSlots(scheduleRequestDTO.getTimeSlotBlockedList());

        ClinicSchedule savedSchedule = clinicScheduleRepository.save(existingSchedule);

        return ScheduleMapper.toResponseDTO(savedSchedule);

    }
//    public ScheduleResponseDTO updateSchedule(Long clinicId, ScheduleRequestDTO scheduleRequestDTO){
//        ClinicSchedule existingSchedule = clinicScheduleRepository
//                .findByClinicId(clinicId)
//                .orElseThrow(() -> new RuntimeException("Schedule not found"));
//
//        ClinicSchedule updatedSchedule = ScheduleMapper.toEntity(scheduleRequestDTO);
//        updatedSchedule.setWeeklyHours(existingSchedule.getWeeklyHours());
//        updatedSchedule.setBlockedSlots(existingSchedule.getBlockedSlots());
//        updatedSchedule.setSlotDurationMinutes(existingSchedule.getSlotDurationMinutes());
//        ClinicSchedule savedSchedule = clinicScheduleRepository.save(updatedSchedule);
//        log.info("Schedule updated in the clinic: {}", savedSchedule.getClinicId());
//        return ScheduleMapper.toResponseDTO(savedSchedule);
//    }

    @Override
    @Transactional
    public ScheduleResponseDTO deleteSchedule(Long clinicId){
        ClinicSchedule existingSchedule = clinicScheduleRepository
                .findByClinicId(clinicId)
                .orElseThrow(() -> new RuntimeException("Schedule not found"));

        clinicScheduleRepository.delete(existingSchedule);
        log.info("Schedule deleted in the clinic: {}", existingSchedule.getClinicId());
        return ScheduleMapper.toResponseDTO(existingSchedule);
    }


}
