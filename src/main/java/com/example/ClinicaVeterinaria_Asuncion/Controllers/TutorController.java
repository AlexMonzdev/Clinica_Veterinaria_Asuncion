package com.example.ClinicaVeterinaria_Asuncion.Controllers;

import com.example.ClinicaVeterinaria_Asuncion.Entities.Tutor;
import com.example.ClinicaVeterinaria_Asuncion.Repositories.TutorRepository;
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

    @GetMapping("/tutor")
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

    @GetMapping("/tutor/{phoneNumber}")
    public ResponseEntity<Tutor> getTutorByPhoneNumber(@PathVariable int phoneNumber) {
        Optional<Tutor> optionalTutor = tutorRepository.findByPhoneNumber(phoneNumber);
        if (optionalTutor.isPresent()) {
            return new ResponseEntity<>(optionalTutor.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping ("/tutor/{id}")
    public ResponseEntity<Tutor> updateTutor(@PathVariable Long id, @RequestBody Tutor tutorDetails){
        Optional<Tutor> optionalTutor = tutorRepository.findById(id);

        if (optionalTutor.isPresent()){
            Tutor existingTutor = optionalTutor.get();
            existingTutor.setFirstname(tutorDetails.getFirstname());
            existingTutor.setLastname(tutorDetails.getLastname());
            existingTutor.setPhoneNumber(tutorDetails.getPhoneNumber());

            tutorRepository.save(existingTutor);
            return new ResponseEntity<>(existingTutor, HttpStatus.OK);
    }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping ("/tutor/{id}")
    public ResponseEntity<Tutor> deleteTutor (@PathVariable Long id){
        tutorRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

