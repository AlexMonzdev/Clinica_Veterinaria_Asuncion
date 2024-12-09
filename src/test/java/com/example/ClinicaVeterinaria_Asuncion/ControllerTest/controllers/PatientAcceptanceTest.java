package com.example.ClinicaVeterinaria_Asuncion.ControllerTest.controllers;

import com.example.ClinicaVeterinaria_Asuncion.controllers.PatientController;
import com.example.ClinicaVeterinaria_Asuncion.services.PatientServices;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PatientController.class)
public class PatientAcceptanceTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    private PatientServices patientServices;

    @Test
    void createPatient() throws Exception {
        String patientRequestJson = """
            {
                "name": "Alice Johnson",
                "species": "dog",
                "breed": "american",
                "birthDate": "2024-12-05",
                "tutor": {"id": "1"
                          }
            }
        """;

        String expectedResponseJson = """
            {
                "id": 1,
                "name": "Alice Johnson",
                "species": "dog",
                "breed": "american",
                "birthDate": "2024-12-05",
                "tutor": {"id": "1"
                          }
            }
        """;

        mockMvc.perform(post("/api/clinic/patient")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(patientRequestJson)) // Enviamos el JSON manualmente como el cuerpo de la solicitud
                .andExpect(status().isCreated());
        // .andExpect(content().json(expectedResponseJson)); // Comparamos la respuesta con el JSON esperado


    }
}
