package com.example.ClinicaVeterinaria_Asuncion.controllers;


import com.example.ClinicaVeterinaria_Asuncion.dtos.PetRequestDTO;
import com.example.ClinicaVeterinaria_Asuncion.dtos.PetResponseDTO;
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
    public ResponseEntity<List<PetResponseDTO>> getAllPets() {
        return ResponseEntity.ok(petServices.getAllPets());
    }

    @GetMapping("/pets/{id}")
    public ResponseEntity<PetResponseDTO> getPetById(@PathVariable Long id) {
        var petResponseDTO = petServices.getPetById(id);
        return ResponseEntity.ok(petResponseDTO);
    }

    @PostMapping("/pets")
    public ResponseEntity<PetResponseDTO> addPet(@RequestBody PetRequestDTO petRequestDTO) {
        PetResponseDTO pet = petServices.createPet(petRequestDTO);
        return new ResponseEntity<>(pet,HttpStatus.CREATED);
    }

    @PutMapping("/pets/{id}")
    public ResponseEntity<PetResponseDTO> updatePet(@PathVariable Long id, @RequestBody PetRequestDTO petRequestDTO) {
        try {
            PetResponseDTO updatedPet = petServices.updatePet(petRequestDTO, id);
            return ResponseEntity.ok(updatedPet);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/pets/{id}")
    public ResponseEntity<?> deletePet(@PathVariable Long id) {
        petServices.deleteById(id);
        return new ResponseEntity<>("Pet deleted successfully",HttpStatus.OK);
    }




}
