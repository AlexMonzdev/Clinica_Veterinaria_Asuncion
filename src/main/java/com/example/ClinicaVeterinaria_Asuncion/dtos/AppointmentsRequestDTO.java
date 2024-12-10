package com.example.ClinicaVeterinaria_Asuncion.dtos;

import com.example.ClinicaVeterinaria_Asuncion.entities.Pet;

import java.time.LocalDate;
import java.time.LocalTime;

public record AppointmentsRequestDTO(
        LocalDate date,
        LocalTime time,
        String reason,
        Pet pet
){
}
