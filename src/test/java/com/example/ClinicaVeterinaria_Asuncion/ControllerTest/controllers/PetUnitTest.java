package com.example.ClinicaVeterinaria_Asuncion.ControllerTest.controllers;

import com.example.ClinicaVeterinaria_Asuncion.entities.Guardian;
import com.example.ClinicaVeterinaria_Asuncion.entities.Pet;
import com.example.ClinicaVeterinaria_Asuncion.repositories.PetRepository;
import com.example.ClinicaVeterinaria_Asuncion.repositories.GuardianRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class PetUnitTest {

    @Autowired
    private PetRepository petRepository;
    @Autowired
    private GuardianRepository guardianRepository;


    @Test
    void shouldReturnAllPatients() {

        Guardian guardian = Guardian.builder()
                .name("John Doe")
                .phone("123456789")
                .email("johndoe@example.com")
                .address("123 Main Street")
                .build();
        guardianRepository.save(guardian);

        Pet pet = Pet.builder()
                .name("Coco")
                .species("dog")
                .breed("labrador")
                .birthDate(LocalDate.now())
                .guardian(guardian)
                .build();

        petRepository.save(pet);

        List<Pet> petList = petRepository.findAll();

        Assertions.assertThat(petList).isNotNull();
        Assertions.assertThat(petList.size()).isEqualTo(1);

    }

}
