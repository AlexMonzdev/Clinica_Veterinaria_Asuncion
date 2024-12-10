package com.example.ClinicaVeterinaria_Asuncion.dtos;

public record GuardianRequestDTO(
        String name,
        String email,
        String phone,
        String address
) {
}
