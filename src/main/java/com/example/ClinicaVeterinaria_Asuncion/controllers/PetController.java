package com.example.ClinicaVeterinaria_Asuncion.controllers;


import com.example.ClinicaVeterinaria_Asuncion.dtos.PetRequestDTO;
import com.example.ClinicaVeterinaria_Asuncion.entities.Pet;
import com.example.ClinicaVeterinaria_Asuncion.services.PetServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/clinic")
public class PetController {

    private final PetServices petServices;

    public PetController(PetServices petServices) {
        this.petServices = petServices;
    }

    @GetMapping("/pets")
    public List<Pet> getAllPets() {
        return petServices.getAllService();
    }


    @GetMapping("/pets/{id}")
    public ResponseEntity<Pet> getPetById(@PathVariable Long id) {
        Optional<Pet> optionalPet = petServices.findById(id);
        if (optionalPet.isPresent()) {
            return new ResponseEntity<Pet>(optionalPet.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @PostMapping("/pets/{id}")
    public ResponseEntity<Pet> addPet(@RequestBody PetRequestDTO petRequestDTO) {
        Pet pet = petServices.addPetService(petRequestDTO);
        return new ResponseEntity<>(pet, HttpStatus.CREATED);
    }

    @DeleteMapping("/pets/{id}")
    public ResponseEntity<Void> deletePet(@PathVariable Long id) {
        petServices.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/pets/{id}")
    public ResponseEntity<Pet> updatePet(@PathVariable Long id, @RequestBody PetRequestDTO petRequestDTO) {
        try {
            Pet updatedPet = petServices.updatePetService(id, petRequestDTO);
            return new ResponseEntity<>(updatedPet, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
