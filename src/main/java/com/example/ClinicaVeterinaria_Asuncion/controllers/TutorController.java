package com.example.ClinicaVeterinaria_Asuncion.controllers;

import com.example.ClinicaVeterinaria_Asuncion.dtos.TutorRequest;
import com.example.ClinicaVeterinaria_Asuncion.services.TutorServices;
import com.example.ClinicaVeterinaria_Asuncion.entities.Tutor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/clinic")
public class TutorController {

    private final TutorServices tutorServices;

    public TutorController(TutorServices tutorServices) {
        this.tutorServices = tutorServices;
    }

    @PostMapping ("/tutor")
    public ResponseEntity<Tutor> addTutor(@RequestBody TutorRequest tutorRequest) {
        tutorServices.createTutor(tutorRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping ("/tutor")
    public ResponseEntity <List<Tutor>> getAllTutors(){
        return ResponseEntity.ok(tutorServices.getAllTutors());
    }

    @GetMapping ("/tutor/{id}")
    public ResponseEntity<Tutor> getTutorsById(@PathVariable Long id) {
        Optional<Tutor> optionalTutor = tutorServices.findById(id);
        if (optionalTutor.isPresent()){
            return new ResponseEntity<Tutor>(optionalTutor.get() , HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    /*@PutMapping ("/tutor/{id}")
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

