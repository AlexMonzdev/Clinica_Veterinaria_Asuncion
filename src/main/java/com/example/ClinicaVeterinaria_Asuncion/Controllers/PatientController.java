package com.example.ClinicaVeterinaria_Asuncion.Controllers;

import com.example.ClinicaVeterinaria_Asuncion.Entities.Patient;
import com.example.ClinicaVeterinaria_Asuncion.Repositories.PatientRepository;
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
    public ResponseEntity<Patient> addPatient(@RequestBody Patient patient) {

        Optional<Patient> existingPatient = patientRepository.findByName(patient.getName());

        if (existingPatient.isPresent()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        patientRepository.save(patient);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping ("/patient/{id}")
    public ResponseEntity<Patient> updatePatient(@PathVariable Long id, @RequestBody Patient patientDetails){
        Optional<Patient> optionalPatient = patientRepository.findById(id);

        if (optionalPatient.isPresent()){
            Patient existingPatient = optionalPatient.get();
            existingPatient.setName(patientDetails.getName());
            existingPatient.setGender(patientDetails.getGender());
            existingPatient.setBirthDate(patientDetails.getBirthDate());
            existingPatient.setTutor(patientDetails.getTutor());
            existingPatient.setSpecies(patientDetails.getSpecies());

            patientRepository.save(existingPatient);
            return new ResponseEntity<>(existingPatient, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping ("/patient/{id}")
    public ResponseEntity<Patient> deletePatient (@PathVariable Long id){
        patientRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
