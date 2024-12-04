package com.example.ClinicaVeterinaria_Asuncion.services;


import com.example.ClinicaVeterinaria_Asuncion.dtos.PatientRequestDTO;
import com.example.ClinicaVeterinaria_Asuncion.dtos.PatientResponseDTO;
import com.example.ClinicaVeterinaria_Asuncion.entities.Patient;
import com.example.ClinicaVeterinaria_Asuncion.repositories.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientServices {

    private final PatientRepository patientRepository;

    public PatientServices(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }


    public Patient addPatientService(PatientRequestDTO patientRequestDTO) {
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


    public PatientResponseDTO getPatientById(Long id) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found with id: " + id));
        return new PatientResponseDTO(
                patient.getId(),
                patient.getName(),
                patient.getSpecies(),
                patient.getBreed(),
                patient.getBirthDate(),
                patient.getTutor().getId()
        );


    }

    public Optional<Patient> findById(Long id) {
        return patientRepository.findById(id);

    }

    public void deleteById(Long id) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found with id: " + id));
        patientRepository.delete(patient);
    }


}


