package com.example.ClinicaVeterinaria_Asuncion.services;

import com.example.ClinicaVeterinaria_Asuncion.dtos.GuardianRequestDTO;
import com.example.ClinicaVeterinaria_Asuncion.dtos.GuardianResponseDTO;
import com.example.ClinicaVeterinaria_Asuncion.entities.Guardian;
import com.example.ClinicaVeterinaria_Asuncion.exceptions.GuardianNotFoundException;
import com.example.ClinicaVeterinaria_Asuncion.mappers.GuardianMapper;
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

    public GuardianResponseDTO createGuardian(GuardianRequestDTO guardianRequestDTO) {
        Guardian guardian = GuardianMapper.toEntity(guardianRequestDTO);
        Guardian saveGuardian = guardianRepository.save(guardian);
        return GuardianMapper.toResponse(saveGuardian);
    }

    public List<GuardianResponseDTO> getAllGuardian() {
        List<Guardian> guardianList = guardianRepository.findAll();
        return guardianList.stream().map(GuardianMapper::toResponse).toList();
    }

    public GuardianResponseDTO getGuardianById(Long id) {
        Guardian guardian = guardianRepository.findById(id)
                .orElseThrow(() -> new GuardianNotFoundException("Guardian not found with id: " + id));
        return GuardianMapper.toResponse(guardian);
    }

    public List<Guardian> findByName(String name) {
        return guardianRepository.findByName(name);
    }

    public GuardianResponseDTO updateGuardian(Long id, GuardianRequestDTO guardianRequestDTO) {
        Guardian guardian = guardianRepository.findById(id)
                .orElseThrow(() -> new GuardianNotFoundException("Guardian not found with id: " + id));
        guardian.setName(guardianRequestDTO.name());
        guardian.setEmail(guardianRequestDTO.email());
        guardian.setPhone(guardianRequestDTO.phone());
        guardian.setAddress(guardianRequestDTO.address());
        guardianRepository.save(guardian);
        return GuardianMapper.toResponse(guardian);
    }

    public void deleteById(Long id) {
        Guardian guardian = guardianRepository.findById(id)
                .orElseThrow(() -> new GuardianNotFoundException("Guardian not found with id: " + id));
        guardianRepository.delete(guardian);
    }

}