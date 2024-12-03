package com.example.ClinicaVeterinaria_Asuncion.controllers;

import com.example.ClinicaVeterinaria_Asuncion.dtos.TutorRequest;
import com.example.ClinicaVeterinaria_Asuncion.services.TutorServices;
import com.example.ClinicaVeterinaria_Asuncion.entities.Tutor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clinic")
public class TutorController {

    private final TutorServices tutorServices;

    public TutorController(TutorServices tutorServices) {
        this.tutorServices = tutorServices;
    }

    /* @GetMapping("/tutor")
    public List<Tutor> getAllTutors() {
        return tutorRepository.findAll();
    } */

    @PostMapping ("/tutor")
    public ResponseEntity<Tutor> addTutor(@RequestBody TutorRequest tutorRequest) {
        tutorServices.createTutor(tutorRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }


   /*  @GetMapping("/tutor/{phoneNumber}")
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
            existingTutor.setName(tutorDetails.getName());
            existingTutor.setPhone(tutorDetails.getPhone());
            existingTutor.setEmail(tutorDetails.getEmail());

            tutorRepository.save(existingTutor);
            return new ResponseEntity<>(existingTutor, HttpStatus.OK);
    }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping ("/tutor/{id}")
    public ResponseEntity<Tutor> deleteTutor (@PathVariable Long id){
        tutorRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    } */

}

