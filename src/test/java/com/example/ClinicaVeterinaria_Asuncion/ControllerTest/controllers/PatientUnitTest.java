package com.example.ClinicaVeterinaria_Asuncion.ControllerTest.controllers;

import com.example.ClinicaVeterinaria_Asuncion.entities.Patient;
import com.example.ClinicaVeterinaria_Asuncion.entities.Tutor;
import com.example.ClinicaVeterinaria_Asuncion.repositories.PatientRepository;
import com.example.ClinicaVeterinaria_Asuncion.repositories.TutorRepository;
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
public class PatientUnitTest {

    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private TutorRepository tutorRepository;


    @Test
    void shouldReturnAllPatients() {

        Tutor tutor = Tutor.builder()
                .name("John Doe")
                .phone("123456789")
                .email("johndoe@example.com")
                .address("123 Main Street")
                .build();
        tutorRepository.save(tutor);

        Patient patient = Patient.builder()
                .name("Coco")
                .species("dog")
                .breed("labrador")
                .birthDate(LocalDate.now())
                .tutor(tutor)
                .build();

        patientRepository.save(patient);

        List<Patient> patientList = patientRepository.findAll();

        Assertions.assertThat(patientList).isNotNull();
        Assertions.assertThat(patientList.size()).isEqualTo(1);

    }

}
