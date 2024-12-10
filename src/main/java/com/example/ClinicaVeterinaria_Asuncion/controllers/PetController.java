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

    @GetMapping("/pet")
    public List<Pet> getAllPets() {
        return petServices.getAllService();
    }


    @GetMapping("/pet/{id}")
    public ResponseEntity<Pet> getPetById(@PathVariable Long id) {
        Optional<Pet> optionalPet = petServices.findById(id);
        if (optionalPet.isPresent()) {
            return new ResponseEntity<Pet>(optionalPet.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @PostMapping("/pet")
    public ResponseEntity<Pet> addPet(@RequestBody PetRequestDTO petRequestDTO) {
        Pet pet = petServices.addPetService(petRequestDTO);
        return new ResponseEntity<>(pet, HttpStatus.CREATED);
    }

    @DeleteMapping("/pet/{id}")
    public ResponseEntity<Void> deletePet(@PathVariable Long id) {
        petServices.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/pet/{id}")
    public ResponseEntity<Pet> updatePet(@PathVariable Long id, @RequestBody PetRequestDTO petRequestDTO) {
        try {
            Pet updatedPet = petServices.updatePetService(id, petRequestDTO);
            return new ResponseEntity<>(updatedPet, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
