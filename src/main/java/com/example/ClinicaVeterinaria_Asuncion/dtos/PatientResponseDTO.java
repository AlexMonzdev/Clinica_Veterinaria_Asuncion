package com.example.ClinicaVeterinaria_Asuncion.dtos;

import java.time.LocalDate;

public record PatientResponseDTO(
        Long id,
        String name,
        String species,
        String breed,
        LocalDate birthDate,
        Long tutorId
) {}
