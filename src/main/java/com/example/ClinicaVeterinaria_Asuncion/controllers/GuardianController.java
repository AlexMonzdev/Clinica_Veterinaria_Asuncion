package com.example.ClinicaVeterinaria_Asuncion.controllers;

import com.example.ClinicaVeterinaria_Asuncion.dtos.GuardianRequestDTO;
import com.example.ClinicaVeterinaria_Asuncion.entities.Guardian;
import com.example.ClinicaVeterinaria_Asuncion.services.GuardianServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/clinic")
public class GuardianController {

    private final GuardianServices guardianServices;

    public GuardianController(GuardianServices guardianServices) {
        this.guardianServices = guardianServices;
    }

    @PostMapping("/guardians")
    public ResponseEntity<Guardian> addGuardian(@RequestBody GuardianRequestDTO guardianRequestDTO) {
        var guardianCreated = guardianServices.createGuardian(guardianRequestDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/guardians")
    public ResponseEntity<List<Guardian>> getAllGuardian() {
        return ResponseEntity.ok(guardianServices.getAllGuardian());
    }

    @GetMapping("/guardians/:id")
    public ResponseEntity<Guardian> getGuardianById(@PathVariable Long id) {
        Optional<Guardian> optionalGuardian = guardianServices.findById(id);
        if (optionalGuardian.isPresent()) {
            return new ResponseEntity<Guardian>(optionalGuardian.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    /* @GetMapping("/guardian/name/{name}")
    public ResponseEntity<List<Guardian>> getGuardianByName(@PathVariable("name") String name) {
        List<Guardian> guardian = guardianServices.findByName(name);
        if (guardian.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(guardian, HttpStatus.OK);
    } */   // no es necesario en Sprint3


    @PutMapping("/guardians/:id")
    public ResponseEntity<Guardian> updateGuardian(@PathVariable Long id, @RequestBody GuardianRequestDTO guardianRequestDTO) {
        try {
            Guardian updatedPatient = guardianServices.updateGuardianServices(id, guardianRequestDTO);
            Guardian updateGuardian = null;
            return new ResponseEntity<>(updateGuardian, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/guardians/:id")
    public ResponseEntity<Guardian> deleteGuardian(@PathVariable Long id) {
        guardianServices.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

