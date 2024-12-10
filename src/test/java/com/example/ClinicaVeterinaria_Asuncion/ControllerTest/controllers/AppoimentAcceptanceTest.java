package com.example.ClinicaVeterinaria_Asuncion.ControllerTest.controllers;

import com.example.ClinicaVeterinaria_Asuncion.controllers.AppointmentsController;
import com.example.ClinicaVeterinaria_Asuncion.services.AppointmentsServices;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AppointmentsController.class)
public class AppoimentAcceptanceTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AppointmentsServices appointmentsServices;

    @Test
    void createAppointment() throws Exception {

        String appointmentRequestJson = """
                    {
                        "date": "2024-12-15",
                        "time": "14:30:00",
                        "reason": "Vacunación",
                        "pet": {
                            "id": "1",
                            "name": "Fido",
                            "species": "dog",
                            "breed": "labrador",
                            "birthDate": "2020-05-10"
                        }
                    }
                """;


        String expectedResponseJson = """
                    {
                        "date": "2024-12-15",
                        "time": "14:30:00",
                        "reason": "Vacunación",
                        "pet": {
                            "id": "1",
                            "name": "Fido",
                            "species": "dog",
                            "breed": "labrador",
                            "birthDate": "2020-05-10"
                        }
                    }
                """;


        mockMvc.perform(MockMvcRequestBuilders.post("/api/clinic/appointment")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(appointmentRequestJson)) // Enviamos el JSON manualmente como el cuerpo de la solicitud
                        .andExpect(status().isCreated());


    }


}
