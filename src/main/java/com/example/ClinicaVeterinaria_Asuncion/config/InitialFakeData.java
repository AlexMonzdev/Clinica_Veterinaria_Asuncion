package com.example.ClinicaVeterinaria_Asuncion.config;

import com.example.ClinicaVeterinaria_Asuncion.entities.Appointment;
import com.example.ClinicaVeterinaria_Asuncion.entities.Guardian;
import com.example.ClinicaVeterinaria_Asuncion.entities.Pet;
import com.example.ClinicaVeterinaria_Asuncion.repositories.AppointmentsRepository;
import com.example.ClinicaVeterinaria_Asuncion.repositories.GuardianRepository;
import com.example.ClinicaVeterinaria_Asuncion.repositories.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class InitialFakeData {

    @Autowired
    GuardianRepository guardianRepository;

    @Autowired
    PetRepository petRepository;

    @Autowired
    AppointmentsRepository appointmentRepository;

    @Bean
    public CommandLineRunner initialData() {
        return args -> {
            // Crear Guardians
            List<Guardian> guardianList = new ArrayList<>();
            for (int i = 1; i <= 10; i++) {
                Guardian guardian = Guardian.builder()
                        .name("Tutor " + i)
                        .email("email" + i + "@mail.com")
                        .phone("123456789" + i)
                        .address("Address" + i)
                        .build();
                guardianList.add(guardian);
            }
            guardianList = guardianRepository.saveAll(guardianList);

            List<Pet> petList = new ArrayList<>();
            for (int i = 1; i <= 20; i++) {
                Guardian guardian = guardianList.get(i % guardianList.size());
                Pet pet = Pet.builder()
                        .name("Pet " + i)
                        .species(i % 2 == 0 ? "Dog" : "Cat")
                        .breed("Breed " + i)
                        .birthDate(LocalDate.now().minusYears(1 + i % 5))
                        .guardian(guardian)
                        .build();
                guardian.getAllPets().add(pet);
                petList.add(pet);
            }
            petList = petRepository.saveAll(petList);

            List<Appointment> appointmentList = new ArrayList<>();
            for (int i = 1; i <= 30; i++) {
                Pet pet = petList.get(i % petList.size());
                Appointment appointment = Appointment.builder()
                        .localDate(LocalDate.now().plusDays(i))
                        .localTime(LocalTime.of(9 + (i % 8), 0))
                        .reason("Routine Checkup " + i)
                        .pet(pet)
                        .build();
                pet.getAllAppointments().add(appointment);
                appointmentList.add(appointment);
            }
            appointmentRepository.saveAll(appointmentList);
        };
    }
}
