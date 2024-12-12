package com.example.ClinicaVeterinaria_Asuncion.mappers;


import com.example.ClinicaVeterinaria_Asuncion.dtos.GuardianResponseDTO;
import com.example.ClinicaVeterinaria_Asuncion.dtos.PetRequestDTO;
import com.example.ClinicaVeterinaria_Asuncion.dtos.PetResponseDTO;
import com.example.ClinicaVeterinaria_Asuncion.entities.Guardian;
import com.example.ClinicaVeterinaria_Asuncion.entities.Pet;


public class PetMapper {


    public static Pet toEntity(PetRequestDTO petRequestDTO) {
        Guardian guardian = Guardian.builder().id(petRequestDTO.guardianId()).build();
        return Pet.builder()
                .name(petRequestDTO.name())
                .species(petRequestDTO.species())
                .breed(petRequestDTO.breed())
                .birthDate(petRequestDTO.birthDate())
                .guardian(guardian)
                .build();
    }


    public static PetResponseDTO toResponse(Pet pet) {
            return  PetResponseDTO.builder()
                    .id(pet.getId())
                    .name(pet.getName())
                    .species(pet.getSpecies())
                    .breed(pet.getBreed())
                    .age(pet.getAge())
                    .guardian(pet.getGuardian())
                    .build();
    }
}
