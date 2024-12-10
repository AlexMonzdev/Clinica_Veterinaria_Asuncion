package com.example.ClinicaVeterinaria_Asuncion.services;

import com.example.ClinicaVeterinaria_Asuncion.dtos.GuardianRequestDTO;
import com.example.ClinicaVeterinaria_Asuncion.entities.Guardian;
import com.example.ClinicaVeterinaria_Asuncion.repositories.GuardianRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GuardianServices {
    private final GuardianRepository guardianRepository;

    public GuardianServices(GuardianRepository guardianRepository) {
        this.guardianRepository = guardianRepository;
    }
    public Guardian createGuardian(GuardianRequestDTO guardianRequestDTO) {
        Guardian guardian = new Guardian();
        guardian.setName(guardianRequestDTO.name());
        guardian.setEmail(guardianRequestDTO.email());
        guardian.setPhone(guardianRequestDTO.phone());
        guardian.setAddress(guardianRequestDTO.address());

        return guardianRepository.save(guardian);
    }

    public List<Guardian> getAllGuardian() {
        return guardianRepository.findAll();
    }

    public Optional<Guardian> findById(Long id) {
        return guardianRepository.findById(id);
    }

    public List<Guardian> findByName(String name) {
        return guardianRepository.findByName(name);
    }

    public void deleteById(Long id) {
        Guardian guardian = guardianRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Guardian not found with id: " + id));
        guardianRepository.delete(guardian);
    }

    public Guardian updateGuardianServices(Long id, GuardianRequestDTO guardianRequestDTO) {
            Guardian guardian = guardianRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Guardian not found with id: " + id));

        guardian.setName(guardianRequestDTO.name());
        guardian.setEmail(guardianRequestDTO.email());
        guardian.setPhone(guardianRequestDTO.phone());
        guardian.setAddress(guardianRequestDTO.address());

        return guardianRepository.save(guardian);
    }

        }