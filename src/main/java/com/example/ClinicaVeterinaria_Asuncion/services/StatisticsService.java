package com.example.ClinicaVeterinaria_Asuncion.services;

import com.example.ClinicaVeterinaria_Asuncion.dtos.StatisticsResponseDTO;
import com.example.ClinicaVeterinaria_Asuncion.repositories.AppointmentsRepository;
import com.example.ClinicaVeterinaria_Asuncion.repositories.PatientRepository;
import com.example.ClinicaVeterinaria_Asuncion.repositories.TutorRepository;
import org.springframework.stereotype.Service;

@Service
public class StatisticsService {

    private final TutorRepository tutorRepository;
    private final PatientRepository patientRepository;
    private final AppointmentsRepository appointmentsRepository;


    public StatisticsService(TutorRepository tutorRepository, PatientRepository patientRepository, AppointmentsRepository appointmentsRepository) {
        this.tutorRepository = tutorRepository;
        this.patientRepository = patientRepository;
        this.appointmentsRepository = appointmentsRepository;
    }

    public StatisticsResponseDTO coutStats(){
        long patients = tutorRepository.count();
        long tutors = patientRepository.count();
        long appoiments = appointmentsRepository.count();

        return new  StatisticsResponseDTO(patients,tutors,appoiments);
    }

}
