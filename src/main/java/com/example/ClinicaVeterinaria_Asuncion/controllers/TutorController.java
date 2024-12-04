package com.example.ClinicaVeterinaria_Asuncion.controllers;


import com.example.ClinicaVeterinaria_Asuncion.dtos.TutorRequestDTO;
import com.example.ClinicaVeterinaria_Asuncion.entities.Tutor;
import com.example.ClinicaVeterinaria_Asuncion.services.TutorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clinic")
public class TutorController {

    private final TutorService tutorService;

    public TutorController(TutorService tutorService) {
        this.tutorService = tutorService;
    }

    @GetMapping ("/tutor")
    public ResponseEntity<List<Tutor>> getAllTutors(){
        return ResponseEntity.ok(tutorService.getAllTutors());
    }

    @PostMapping ("/tutor")
    public ResponseEntity<TutorRequestDTO> createTutor(@RequestBody TutorRequestDTO tutorRequestDTO) {
        tutorService.createTutorService(tutorRequestDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }



}
