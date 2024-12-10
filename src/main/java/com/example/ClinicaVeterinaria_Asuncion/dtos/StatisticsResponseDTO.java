package com.example.ClinicaVeterinaria_Asuncion.dtos;

public record StatisticsResponseDTO(
        Long appointments,
        Long guardians,
        Long patients
) {
}
