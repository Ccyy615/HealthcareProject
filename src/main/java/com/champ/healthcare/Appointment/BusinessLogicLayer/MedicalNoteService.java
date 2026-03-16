package com.champ.healthcare.Appointment.BusinessLogicLayer;

import com.champ.healthcare.Appointment.DataAccessLayer.MedicalNoteRepository;
import com.champ.healthcare.Appointment.Domain.Appointment;
import com.champ.healthcare.Appointment.Domain.MedicalNote;
import com.champ.healthcare.Appointment.Mapper.*;
import com.champ.healthcare.Appointment.PresentationLayer.*;
import com.champ.healthcare.utilities.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class MedicalNoteService {

    private final MedicalNoteRepository medicalNoteRepository;
    private final MedicalNoteMapper  medicalNoteMapper;

    @Transactional(readOnly = true)
    public List<MedicalNoteResponseDTO> getAllNotes() {
        return MedicalNoteMapper.toResponseDTOList(medicalNoteRepository.findAll());
    }

    @Transactional(readOnly = true)
    public MedicalNoteResponseDTO getNoteById(Long noteId) {
        MedicalNote note = medicalNoteRepository
                .findByNoteId(noteId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Note not found with ID: " + noteId));
        return MedicalNoteMapper.toResponseDTO(note);
    }

    @Transactional
    public MedicalNoteResponseDTO createNote(MedicalNoteRequestDTO dto) {
        MedicalNote note = MedicalNoteMapper.toEntity(dto);
        MedicalNote saveNote = medicalNoteRepository.save(note);
        return MedicalNoteMapper.toResponseDTO(saveNote);
    }

    @Transactional
    public MedicalNoteResponseDTO updateNote(Long noteId, MedicalNoteRequestDTO dto) {
        MedicalNote note = medicalNoteRepository
                .findByNoteId(noteId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Note not found with ID: " + noteId));
        MedicalNote updateNote = MedicalNoteMapper.toEntity(dto);
        updateNote.setNoteId(noteId);
        updateNote.setNoteText(note.getNoteText());
        updateNote.setNoteType(note.getNoteType());

        MedicalNote saveNote = medicalNoteRepository.save(updateNote);
        return MedicalNoteMapper.toResponseDTO(saveNote);
    }

    @Transactional
    public MedicalNoteResponseDTO deletenote(Long noteId) {
        MedicalNote note = medicalNoteRepository
                .findByNoteId(noteId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Note not found with ID: " + noteId));
        medicalNoteRepository.delete(note);
        return MedicalNoteMapper.toResponseDTO(note);
    }
}
