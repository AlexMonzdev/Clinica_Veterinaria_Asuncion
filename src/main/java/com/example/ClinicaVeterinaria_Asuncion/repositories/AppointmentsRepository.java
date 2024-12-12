package com.example.ClinicaVeterinaria_Asuncion.repositories;

import com.example.ClinicaVeterinaria_Asuncion.entities.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentsRepository extends JpaRepository<Appointment, Long> {
}
