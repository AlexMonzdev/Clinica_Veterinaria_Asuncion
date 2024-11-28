package com.example.ClinicaVeterinaria_Asuncion.Repositories;

import com.example.ClinicaVeterinaria_Asuncion.Entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    Optional<Patient> findByName(String name);
}
