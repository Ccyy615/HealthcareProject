package com.champ.healthcare.ClinicAvailability.BusinessLogicLayer;

import com.champ.healthcare.ClinicAvailability.PresentationLayer.ScheduleRequestDTO;
import com.champ.healthcare.ClinicAvailability.PresentationLayer.ScheduleResponseDTO;

import java.util.List;

public interface ScheduleService {

    List<ScheduleResponseDTO> getAllSchedules();
    ScheduleResponseDTO getScheduleById(Long clinicId);

    ScheduleResponseDTO createSchedule(ScheduleRequestDTO dto);
    ScheduleResponseDTO updateSchedule(Long clinicId, ScheduleRequestDTO dto);
    ScheduleResponseDTO deleteSchedule(Long clinicId);

    // Status transitions
//    ScheduleResponseDTO openClinic(Long clinicId);
//    ScheduleResponseDTO closeClinic(Long clinicId);
}
