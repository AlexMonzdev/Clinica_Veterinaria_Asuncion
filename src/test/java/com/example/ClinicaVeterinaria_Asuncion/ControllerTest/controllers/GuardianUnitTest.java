package com.example.ClinicaVeterinaria_Asuncion.ControllerTest.controllers;

import com.example.ClinicaVeterinaria_Asuncion.entities.Guardian;
import com.example.ClinicaVeterinaria_Asuncion.repositories.GuardianRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class GuardianUnitTest {

    @Autowired
    private GuardianRepository guardianRepository;

    @Test
    void shouldReturnAllTutors(){
        Guardian guardian = Guardian.builder().name("Alex").email("alexmonzon@hotmail.com").phone("624601902").address("C/diez 55").build();
        guardianRepository.save(guardian);
        List<Guardian> guardianList = guardianRepository.findAll();
        Assertions.assertThat(guardianList).isNotNull();
        Assertions.assertThat(guardianList.size()).isEqualTo(1);

    }

}
