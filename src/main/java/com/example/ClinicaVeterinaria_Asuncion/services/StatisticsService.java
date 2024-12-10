package com.example.ClinicaVeterinaria_Asuncion.services;

import com.example.ClinicaVeterinaria_Asuncion.dtos.StatisticsResponseDTO;
import com.example.ClinicaVeterinaria_Asuncion.repositories.AppointmentsRepository;
import com.example.ClinicaVeterinaria_Asuncion.repositories.PetRepository;
import com.example.ClinicaVeterinaria_Asuncion.repositories.GuardianRepository;
import org.springframework.stereotype.Service;

@Service
public class StatisticsService {

    private final GuardianRepository guardianRepository;
    private final PetRepository petRepository;
    private final AppointmentsRepository appointmentsRepository;


    public StatisticsService(GuardianRepository guardianRepository, PetRepository petRepository, AppointmentsRepository appointmentsRepository) {
        this.guardianRepository = guardianRepository;
        this.petRepository = petRepository;
        this.appointmentsRepository = appointmentsRepository;
    }

    public StatisticsResponseDTO countStats(){
        long patients = guardianRepository.count();
        long guardians = petRepository.count();
        long appointments = appointmentsRepository.count();

        return new  StatisticsResponseDTO(patients,guardians,appointments);
    }

}
