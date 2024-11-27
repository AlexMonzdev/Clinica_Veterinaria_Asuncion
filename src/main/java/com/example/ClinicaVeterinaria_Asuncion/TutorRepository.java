package com.example.ClinicaVeterinaria_Asuncion;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TutorRepository extends JpaRepository<Tutor, Long> {

    Optional<Tutor> findByPhoneNumber(int phoneNumber);
}
