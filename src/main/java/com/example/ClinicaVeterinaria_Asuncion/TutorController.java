package com.example.ClinicaVeterinaria_Asuncion;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/api/clinica")
public class TutorController extends Tutor {

    private final Tutor tutor;

    public TutorController(String name, long idNumber, String associatedPatient, Tutor tutor) {
        super(name, idNumber, associatedPatient);
        this.tutor = tutor;
    }

    @GetMapping
    public List<Tutor> getAllTutors() {
        return tutor.findAll();
    }


}

