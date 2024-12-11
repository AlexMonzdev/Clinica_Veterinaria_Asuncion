package com.example.ClinicaVeterinaria_Asuncion.mappers;

import com.example.ClinicaVeterinaria_Asuncion.dtos.GuardianRequestDTO;
import com.example.ClinicaVeterinaria_Asuncion.dtos.GuardianResponseDTO;
import com.example.ClinicaVeterinaria_Asuncion.entities.Guardian;

public class GuardianMapper {

    public static Guardian toEntity(GuardianRequestDTO guardianRequestDTO) {
        return Guardian.builder()
                .name(guardianRequestDTO.name())
                .email(guardianRequestDTO.email())
                .phone(guardianRequestDTO.phone())
                .address(guardianRequestDTO.address()).build();
    }

    public static GuardianResponseDTO toResponse(Guardian guardian) {
        return GuardianResponseDTO.builder()
                .id(guardian.getId())
                .name(guardian.getName())
                .email(guardian.getEmail())
                .phone(guardian.getPhone())
                .address(guardian.getAddress())
                .build();
    }

}
