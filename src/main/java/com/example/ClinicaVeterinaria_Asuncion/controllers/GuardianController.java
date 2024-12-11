package com.example.ClinicaVeterinaria_Asuncion.controllers;

import com.example.ClinicaVeterinaria_Asuncion.dtos.GuardianRequestDTO;
import com.example.ClinicaVeterinaria_Asuncion.dtos.GuardianResponseDTO;
import com.example.ClinicaVeterinaria_Asuncion.dtos.PetResponseDTO;
import com.example.ClinicaVeterinaria_Asuncion.entities.Guardian;
import com.example.ClinicaVeterinaria_Asuncion.services.GuardianServices;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clinic")
public class GuardianController {

    private final GuardianServices guardianServices;

    public GuardianController(GuardianServices guardianServices) {
        this.guardianServices = guardianServices;
    }

    @GetMapping("/guardians")
    public ResponseEntity<List<GuardianResponseDTO>> getAllGuardian() {
        return ResponseEntity.ok(guardianServices.getAllGuardian());
    }

    @GetMapping("/guardians/{id}")
    public ResponseEntity<GuardianResponseDTO> getGuardianById(@PathVariable Long id) {
        GuardianResponseDTO GuardianResponseDTO = guardianServices.getGuardianById(id);
        return ResponseEntity.ok(GuardianResponseDTO);
    }

    @PostMapping("/guardians")
    public ResponseEntity<Guardian> addGuardian(@Valid @RequestBody GuardianRequestDTO guardianRequestDTO) {
        GuardianResponseDTO guardianCreated = guardianServices.createGuardian(guardianRequestDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @PutMapping("/guardians/{id}")
    public ResponseEntity<GuardianResponseDTO> updateGuardian(@PathVariable Long id, @RequestBody GuardianRequestDTO guardianRequestDTO) {
        try {
            GuardianResponseDTO updatedGuardian = guardianServices.updateGuardian(id, guardianRequestDTO);
            return ResponseEntity.ok(updatedGuardian);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/guardians/{id}")
    public ResponseEntity<?> deleteGuardian(@PathVariable Long id) {
        guardianServices.deleteById(id);
        return new ResponseEntity<>("Guardian deleted successfully",HttpStatus.OK);
    }

}

