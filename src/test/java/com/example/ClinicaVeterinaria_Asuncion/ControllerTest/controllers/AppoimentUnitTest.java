package com.example.ClinicaVeterinaria_Asuncion.ControllerTest.controllers;

import com.example.ClinicaVeterinaria_Asuncion.entities.Appointments;
import com.example.ClinicaVeterinaria_Asuncion.entities.Pet;
import com.example.ClinicaVeterinaria_Asuncion.entities.Guardian;
import com.example.ClinicaVeterinaria_Asuncion.repositories.AppointmentsRepository;
import com.example.ClinicaVeterinaria_Asuncion.repositories.PetRepository;
import com.example.ClinicaVeterinaria_Asuncion.repositories.GuardianRepository;
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
    private PetRepository petRepository;

    @Autowired
    private GuardianRepository guardianRepository;

    @Test
    void shouldReturnAllAppoiment() {

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

            Appointments appointment = Appointments.builder()
                    .localDate(LocalDate.of(2024, 12, 15))
                    .localTime(LocalTime.of(14, 30))
                    .reason("Vacunación")
                    .pet(pet)
                    .build();
            appointmentsRepository.save(appointment);

            List<Appointments> appointmentsList = appointmentsRepository.findAll();

            Assertions.assertThat(appointmentsList).isNotNull();
            Assertions.assertThat(appointmentsList.size()).isEqualTo(1);

            Appointments retrievedAppointment = appointmentsList.get(0);
            Assertions.assertThat(retrievedAppointment.getLocalDate()).isEqualTo(LocalDate.of(2024, 12, 15));
            Assertions.assertThat(retrievedAppointment.getLocalTime()).isEqualTo(LocalTime.of(14, 30));
            Assertions.assertThat(retrievedAppointment.getReason()).isEqualTo("Vacunación");

            Pet retrievedPet = retrievedAppointment.getPet();
            Assertions.assertThat(retrievedPet).isNotNull();
            Assertions.assertThat(retrievedPet.getName()).isEqualTo("Coco");


            Guardian retrievedGuardian = retrievedPet.getGuardian();
            Assertions.assertThat(retrievedGuardian).isNotNull();
            Assertions.assertThat(retrievedGuardian.getName()).isEqualTo("John Doe");
    }
}
