package com.example.ClinicaVeterinaria_Asuncion.Repositories;

import com.example.ClinicaVeterinaria_Asuncion.Entities.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TutorRepository extends JpaRepository<Tutor, Long> {

    Optional<Tutor> findByPhoneNumber(int phoneNumber);
}
