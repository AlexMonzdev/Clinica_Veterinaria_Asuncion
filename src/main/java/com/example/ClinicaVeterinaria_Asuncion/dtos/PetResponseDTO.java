package com.example.ClinicaVeterinaria_Asuncion.dtos;

import java.time.LocalDate;

public record PetResponseDTO(
        Long id,
        String name,
        String species,
        String breed,
        LocalDate birthDate,
        Long guardiansID
) {}
