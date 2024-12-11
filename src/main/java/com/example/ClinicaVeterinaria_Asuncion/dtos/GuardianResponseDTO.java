package com.example.ClinicaVeterinaria_Asuncion.dtos;

import lombok.Builder;

@Builder
public record GuardianResponseDTO(
        long id,
        String name,
        String email,
        String phone,
        String address
) {
}
