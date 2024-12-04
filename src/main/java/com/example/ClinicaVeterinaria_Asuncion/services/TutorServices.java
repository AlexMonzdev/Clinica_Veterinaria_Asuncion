package com.example.ClinicaVeterinaria_Asuncion.services;

import com.example.ClinicaVeterinaria_Asuncion.dtos.TutorRequest;
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
    public Tutor createTutor(TutorRequest tutorRequest) {
        Tutor tutor = new Tutor();
        tutor.setName(tutorRequest.name());
        tutor.setEmail(tutorRequest.email());
        tutor.setPhone(tutorRequest.phone());
        tutor.setAddress(tutorRequest.address());

        return tutorRepository.save(tutor);
    }

    public List<Tutor> getAllTutors() {
        return tutorRepository.findAll();
    }

    public Optional<Tutor> findById(Long id) {
        return tutorRepository.findById(id);
    }
}
