package com.example.ClinicaVeterinaria_Asuncion.services;

import com.example.ClinicaVeterinaria_Asuncion.dtos.TutorRequestDTO;
import com.example.ClinicaVeterinaria_Asuncion.entities.Tutor;
import com.example.ClinicaVeterinaria_Asuncion.repositories.TutorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TutorServices {
    private final TutorRepository tutorRepository;

    public TutorServices (TutorRepository tutorRepository) {
        this.tutorRepository = tutorRepository;
    }
    public Tutor createTutor(TutorRequestDTO tutorRequestDTO) {
        Tutor tutor = new Tutor();
        tutor.setName(tutorRequestDTO.name());
        tutor.setEmail(tutorRequestDTO.email());
        tutor.setPhone(tutorRequestDTO.phone());
        tutor.setAddress(tutorRequestDTO.address());

        return tutorRepository.save(tutor);
    }

    public List<Tutor> getAllTutors() {
        return tutorRepository.findAll();
    }

    public Optional<Tutor> findById(Long id) {
        return tutorRepository.findById(id);
    }

    public List<Tutor> findByName(String name) {
        return tutorRepository.findByName(name);
    }

    public void deleteById(Long id) {
        Tutor tutor = tutorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tutor not found with id: " + id));
        tutorRepository.delete(tutor);
    }

    public Tutor updateTutorServices(Long id, TutorRequestDTO tutorRequestDTO) {
            Tutor tutor = tutorRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Tutor not found with id: " + id));

        tutor.setName(tutorRequestDTO.name());
        tutor.setEmail(tutorRequestDTO.email());
        tutor.setPhone(tutorRequestDTO.phone());
        tutor.setAddress(tutorRequestDTO.address());

        return tutorRepository.save(tutor);
    }

        }