package com.example.ClinicaVeterinaria_Asuncion.services;

import com.example.ClinicaVeterinaria_Asuncion.dtos.PatienRequestDTO;
import com.example.ClinicaVeterinaria_Asuncion.entities.Patient;
import com.example.ClinicaVeterinaria_Asuncion.exeptions.PatientNotFoundException;
import com.example.ClinicaVeterinaria_Asuncion.repositories.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServices {

    private final PatientRepository patientRepository;

    public PatientServices(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }


    public Patient addPatientService(PatienRequestDTO patientRequestDTO) {
        Patient patient = new Patient();
        patient.setName(patientRequestDTO.name());
        patient.setSpecies(patientRequestDTO.species());
        patient.setBreed(patientRequestDTO.breed());
        patient.setBirthDate(patientRequestDTO.birthDate());
        patient.setTutor(patientRequestDTO.tutor());
        return patientRepository.save(patient);

    }

    public List<Patient> getAllService() {
        return patientRepository.findAll();
    }


    public void getPatientByIdService(Long id) {
        patientRepository.findById(id)
                .orElseThrow(() -> new PatientNotFoundException("Patient not found with id: " + id));
    }

}
