package com.example.ClinicaVeterinaria_Asuncion.controllers;

import com.example.ClinicaVeterinaria_Asuncion.dtos.TutorRequestDTO;
import com.example.ClinicaVeterinaria_Asuncion.services.TutorService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/clinic")
public class TutorController {

    private final TutorService tutorService;

    public TutorController(TutorService tutorService) {
        this.tutorService = tutorService;
    }

    @PostMapping("/tutor")
    public void createTutor(@RequestBody TutorRequestDTO tutorRequestDto) {
        tutorService.createTutorService(tutorRequestDto);
    }



}
