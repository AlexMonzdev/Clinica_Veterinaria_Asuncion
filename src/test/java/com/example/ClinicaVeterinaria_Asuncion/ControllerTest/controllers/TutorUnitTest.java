package com.example.ClinicaVeterinaria_Asuncion.ControllerTest.controllers;

import com.example.ClinicaVeterinaria_Asuncion.entities.Tutor;
import com.example.ClinicaVeterinaria_Asuncion.repositories.TutorRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class TutorUnitTest {

    @Autowired
    private TutorRepository tutorRepository;

    @Test
    void shouldReturnAllTutors(){
        Tutor tutor = Tutor.builder().name("Alex").email("alexmonzon@hotmail.com").phone("624601902").address("C/diez 55").build();
        tutorRepository.save(tutor);
        List<Tutor> tutorList = tutorRepository.findAll();
        Assertions.assertThat(tutorList).isNotNull();
        Assertions.assertThat(tutorList.size()).isEqualTo(1);

    }

}
