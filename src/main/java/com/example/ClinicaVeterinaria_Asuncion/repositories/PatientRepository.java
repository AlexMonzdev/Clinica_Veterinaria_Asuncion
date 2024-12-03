package com.example.ClinicaVeterinaria_Asuncion.repositories;

import com.example.ClinicaVeterinaria_Asuncion.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    Optional<Patient> findByName(String name);
}
