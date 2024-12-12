package com.example.ClinicaVeterinaria_Asuncion.dtos;

import com.example.ClinicaVeterinaria_Asuncion.entities.Guardian;
import lombok.Builder;

import java.time.LocalDate;

@Builder
public record PetResponseDTO(
        Long id,
        String name,
        String species,
        String breed,
        int age,
        Guardian guardian

) {}
