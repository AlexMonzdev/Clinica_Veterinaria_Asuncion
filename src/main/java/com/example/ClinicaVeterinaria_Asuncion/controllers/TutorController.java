package com.example.ClinicaVeterinaria_Asuncion.controllers;

import com.example.ClinicaVeterinaria_Asuncion.dtos.TutorRequestDTO;
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
    public ResponseEntity<Tutor> addTutor(@RequestBody TutorRequestDTO tutorRequestDTO) {
        tutorServices.createTutor(tutorRequestDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
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

   /* @GetMapping ("/tutor/{name}")
        public ResponseEntity <List<Tutor>> getTutorByName(@PathParam("name") String name) {
        Optional<Tutor> tutors = tutorServices.findByName(name);
        return null;

    } */

    @GetMapping("/tutor/name/{name}")
    public ResponseEntity<List<Tutor>> getTutorByName(@PathVariable("name") String name) {
        List<Tutor> tutors = tutorServices.findByName(name);
        if (tutors.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(tutors, HttpStatus.OK);
    }


    /*@PutMapping ("/tutor/{id}")
    public ResponseEntity<Tutor> updateTutor(@PathVariable Long id, @RequestBody TutorRequestDTO tutorDetails){
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
    } */

    @PutMapping("/tutor/{id}")
    public ResponseEntity<Tutor> updateTutor(@PathVariable Long id, @RequestBody TutorRequestDTO tutorRequestDTO) {
        try {
            Tutor updatedPatient = tutorServices.updateTutorServices(id, tutorRequestDTO);
            Tutor updateTutor = null;
            return new ResponseEntity<>(updateTutor, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping ("/tutor/{id}")
    public ResponseEntity<Tutor> deleteTutor (@PathVariable Long id){
        tutorServices.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

