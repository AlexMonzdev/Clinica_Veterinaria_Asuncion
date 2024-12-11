package com.example.ClinicaVeterinaria_Asuncion.dtos;

import com.example.ClinicaVeterinaria_Asuncion.entities.Guardian;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

import java.time.LocalDate;

public record PetRequestDTO(
        @NotBlank(message = "Name cannot be empty")
        String name,

        @NotBlank(message = "Species cannot be empty")
        String species,

        @NotBlank(message = "Breed cannot be empty")
        String breed,

        @NotNull(message = "Birth date cannot be null")
        @Past(message = "Birth date must be in the past")
        LocalDate birthDate,

        @NotNull(message = "Guardian cannot be null")
        Long guardianId
){}
