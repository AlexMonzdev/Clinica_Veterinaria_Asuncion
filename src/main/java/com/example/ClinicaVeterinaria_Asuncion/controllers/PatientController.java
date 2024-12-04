package com.example.ClinicaVeterinaria_Asuncion.controllers;


import com.example.ClinicaVeterinaria_Asuncion.dtos.PatientRequestDTO;
import com.example.ClinicaVeterinaria_Asuncion.entities.Patient;
import com.example.ClinicaVeterinaria_Asuncion.services.PatientServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/clinic")
public class PatientController {

    private final PatientServices patientServices;

    public PatientController(PatientServices patientServices) {
        this.patientServices = patientServices;
    }

    @GetMapping("/patient")
    public List<Patient> getAllPatients() {
        return patientServices.getAllService();
    }


    @GetMapping ("/patient/{id}")
    public ResponseEntity<Patient> getPatientById (@PathVariable Long id){
        Optional<Patient> optionalPatient = patientServices.findById(id);
        if (optionalPatient.isPresent()){
            return new ResponseEntity<Patient>(optionalPatient.get() , HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @PostMapping("/patient")
    public ResponseEntity<Patient> addPatient(@RequestBody PatientRequestDTO patientRequestDTO) {
        Patient patient = patientServices.addPatientService(patientRequestDTO);
        return new ResponseEntity<>(patient, HttpStatus.CREATED);
    }



//    @PutMapping ("/patient/{id}")
//    public ResponseEntity<Patient> updatePatient(@PathVariable Long id, @RequestBody Patient patientDetails){
//        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }
//
//    @DeleteMapping ("/patient/{id}")
//    public ResponseEntity<Patient> deletePatient (@PathVariable Long id){
//        patientRepository.deleteById(id);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }

}
