package com.example.ClinicaVeterinaria_Asuncion.repositories;

import com.example.ClinicaVeterinaria_Asuncion.entities.Guardian;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GuardianRepository extends JpaRepository<Guardian, Long> {
    List<Guardian> findByName(String name);
}
