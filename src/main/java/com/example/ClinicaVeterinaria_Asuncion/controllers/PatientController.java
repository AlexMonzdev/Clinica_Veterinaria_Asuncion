package com.example.ClinicaVeterinaria_Asuncion.controllers;

import com.example.ClinicaVeterinaria_Asuncion.Patient;
import com.example.ClinicaVeterinaria_Asuncion.PatientRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/clinic")
public class PatientController {

    private final PatientRepository patientRepository;

    public PatientController(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @GetMapping("/patient")
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @PostMapping("/patient")
    public ResponseEntity<Patient> addTutor(@RequestBody Patient patient) {

        Optional<Patient> existingPatient = patientRepository.findByName(patient.getName());

        if (existingPatient.isPresent()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        patientRepository.save(patient);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
