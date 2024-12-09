package com.example.ClinicaVeterinaria_Asuncion.ControllerTest.controllers;

import com.example.ClinicaVeterinaria_Asuncion.entities.Appointments;
import com.example.ClinicaVeterinaria_Asuncion.entities.Patient;
import com.example.ClinicaVeterinaria_Asuncion.entities.Tutor;
import com.example.ClinicaVeterinaria_Asuncion.repositories.AppointmentsRepository;
import com.example.ClinicaVeterinaria_Asuncion.repositories.PatientRepository;
import com.example.ClinicaVeterinaria_Asuncion.repositories.TutorRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class AppoimentUnitTest {

    @Autowired
    private AppointmentsRepository appointmentsRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private TutorRepository tutorRepository;

    @Test
    void shouldReturnAllAppoiment() {

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

            Appointments appointment = Appointments.builder()
                    .localDate(LocalDate.of(2024, 12, 15))
                    .localTime(LocalTime.of(14, 30))
                    .reason("Vacunación")
                    .patient(patient)
                    .build();
            appointmentsRepository.save(appointment);

            List<Appointments> appointmentsList = appointmentsRepository.findAll();

            Assertions.assertThat(appointmentsList).isNotNull();
            Assertions.assertThat(appointmentsList.size()).isEqualTo(1);

            Appointments retrievedAppointment = appointmentsList.get(0);
            Assertions.assertThat(retrievedAppointment.getLocalDate()).isEqualTo(LocalDate.of(2024, 12, 15));
            Assertions.assertThat(retrievedAppointment.getLocalTime()).isEqualTo(LocalTime.of(14, 30));
            Assertions.assertThat(retrievedAppointment.getReason()).isEqualTo("Vacunación");

            Patient retrievedPatient = retrievedAppointment.getPatient();
            Assertions.assertThat(retrievedPatient).isNotNull();
            Assertions.assertThat(retrievedPatient.getName()).isEqualTo("Coco");


            Tutor retrievedTutor = retrievedPatient.getTutor();
            Assertions.assertThat(retrievedTutor).isNotNull();
            Assertions.assertThat(retrievedTutor.getName()).isEqualTo("John Doe");
    }
}
