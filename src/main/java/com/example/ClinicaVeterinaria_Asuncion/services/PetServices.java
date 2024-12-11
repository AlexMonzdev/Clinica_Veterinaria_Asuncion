package com.example.ClinicaVeterinaria_Asuncion.services;


import com.example.ClinicaVeterinaria_Asuncion.dtos.PetRequestDTO;
import com.example.ClinicaVeterinaria_Asuncion.dtos.PetResponseDTO;
import com.example.ClinicaVeterinaria_Asuncion.entities.Guardian;
import com.example.ClinicaVeterinaria_Asuncion.entities.Pet;
import com.example.ClinicaVeterinaria_Asuncion.exceptions.GuardianNotFoundException;
import com.example.ClinicaVeterinaria_Asuncion.exceptions.PetNotFoundException;
import com.example.ClinicaVeterinaria_Asuncion.mappers.PetMapper;
import com.example.ClinicaVeterinaria_Asuncion.repositories.GuardianRepository;
import com.example.ClinicaVeterinaria_Asuncion.repositories.PetRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetServices {

    private final PetRepository petRepository;
    private final GuardianRepository guardianRepository;

    public PetServices(PetRepository petRepository, GuardianRepository guardianRepository) {
        this.petRepository = petRepository;
        this.guardianRepository = guardianRepository;
    }


    public PetResponseDTO createPet(PetRequestDTO petRequestDTO) {
        Pet pet = PetMapper.toEntity(petRequestDTO);
        Pet savePet = petRepository.save(pet);
        return PetMapper.toResponse(savePet);

    }

    public List<Pet> getAllService() {
        return petRepository.findAll();
    }


    public PetResponseDTO getPetById(Long id) {
        Pet pet = petRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pet not found with id: " + id));
        return PetMapper.toResponse(pet);
    }

    public PetResponseDTO updatePet(Long id, PetRequestDTO petRequestDTO) {
        Pet pet = petRepository.findById(id)
                .orElseThrow(() -> new PetNotFoundException("Pet not found with id: " + id));
        Guardian guardian = guardianRepository.findById(petRequestDTO.guardianId())
                .orElseThrow(() -> new GuardianNotFoundException("Guardian not found with id: " + petRequestDTO.guardianId()));
        pet.setName(petRequestDTO.name());
        pet.setSpecies(petRequestDTO.species());
        pet.setBreed(petRequestDTO.breed());
        pet.setBirthDate(petRequestDTO.birthDate());
        pet.setGuardian(guardian);
        petRepository.save(pet);
        return PetMapper.toResponse(pet);

    }


    public void deleteById(Long id) {
        Pet pet = petRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pet not found with id: " + id));
        petRepository.delete(pet);
    }




}



