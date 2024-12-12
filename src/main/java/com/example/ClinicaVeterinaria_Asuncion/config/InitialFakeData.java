package com.example.ClinicaVeterinaria_Asuncion.config;

import com.example.ClinicaVeterinaria_Asuncion.entities.Guardian;
import com.example.ClinicaVeterinaria_Asuncion.repositories.GuardianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.security.Guard;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class InitialFakeData {

    @Autowired
    GuardianRepository guardianRepository;

    @Bean
    public CommandLineRunner initialData() {
        return args -> {
            List<Guardian> guardianList =  new ArrayList<>();
            for (int i = 1; i <= 10; i++) {
                guardianList.add(Guardian.builder()
                        .name("Tutor " + i)
                        .email("email" + i + "@mail.com")
                        .phone("123456789" + i) //
                        .address("Address" + i) //
                        .build());
            }
            guardianRepository.saveAll(guardianList);
        };
    }

}