package com.example.ClinicaVeterinaria_Asuncion.services;


import com.example.ClinicaVeterinaria_Asuncion.dtos.PetRequestDTO;
import com.example.ClinicaVeterinaria_Asuncion.dtos.PetResponseDTO;
import com.example.ClinicaVeterinaria_Asuncion.entities.Pet;
import com.example.ClinicaVeterinaria_Asuncion.repositories.PetRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetServices {

    private final PetRepository petRepository;

    public PetServices(PetRepository petRepository) {
        this.petRepository = petRepository;
    }


    public Pet addPetService(PetRequestDTO petRequestDTO) {
        Pet pet = new Pet();
        pet.setName(petRequestDTO.name());
        pet.setSpecies(petRequestDTO.species());
        pet.setBreed(petRequestDTO.breed());
        pet.setBirthDate(petRequestDTO.birthDate());
        pet.setGuardian(petRequestDTO.guardian());
        return petRepository.save(pet);

    }

    public List<Pet> getAllService() {
        return petRepository.findAll();
    }


    public PetResponseDTO getPetById(Long id) {
        Pet pet = petRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pet not found with id: " + id));
        return new PetResponseDTO(
                pet.getId(),
                pet.getName(),
                pet.getSpecies(),
                pet.getBreed(),
                pet.getBirthDate(),
                pet.getGuardian().getId()
        );


    }

    public Optional<Pet> findById(Long id) {
        return petRepository.findById(id);

    }

    public void deleteById(Long id) {
        Pet pet = petRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pet not found with id: " + id));
        petRepository.delete(pet);
    }


    public Pet updatePetService(Long id, PetRequestDTO petRequestDTO) {
        Pet pet = petRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pet not found with id: " + id));

        pet.setName(petRequestDTO.name());
        pet.setSpecies(petRequestDTO.species());
        pet.setBreed(petRequestDTO.breed());
        pet.setBirthDate(petRequestDTO.birthDate());
        pet.setGuardian(petRequestDTO.guardian());
        return petRepository.save(pet);

    }

}



