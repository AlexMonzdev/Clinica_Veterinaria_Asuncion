package com.example.ClinicaVeterinaria_Asuncion;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/clinic")
public class TutorController {

    private final TutorRepository tutorRepository;


    public TutorController(TutorRepository tutorRepositoryRepository) {
        this.tutorRepository = tutorRepositoryRepository;
    }

    @GetMapping
    public List<Tutor> getAllTutors() {
        return tutorRepository.findAll();
    }

    @PostMapping ("/tutor")
    public ResponseEntity<Tutor> addTutor(@RequestBody Tutor tutor) {

        Optional<Tutor> existingTutor = tutorRepository.findByPhoneNumber(tutor.getPhoneNumber());

        if (existingTutor.isPresent()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        tutorRepository.save(tutor);
        return new ResponseEntity<>(HttpStatus.OK);
    }




}

