package com.example.ClinicaVeterinaria_Asuncion.dtos;

import com.example.ClinicaVeterinaria_Asuncion.entities.Guardian;
import com.example.ClinicaVeterinaria_Asuncion.entities.Pet;
import lombok.Builder;

import java.time.LocalDate;
import java.time.LocalTime;

@Builder
public record AppointmentResponseDTO(
        Long id,
        LocalDate date,
        LocalTime time,
        String reason,
        Pet pet
) { }
