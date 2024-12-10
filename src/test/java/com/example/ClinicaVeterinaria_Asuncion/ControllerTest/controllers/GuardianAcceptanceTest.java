package com.example.ClinicaVeterinaria_Asuncion.ControllerTest.controllers;

import com.example.ClinicaVeterinaria_Asuncion.controllers.GuardianController;
import com.example.ClinicaVeterinaria_Asuncion.services.GuardianServices;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(GuardianController.class)
public class GuardianAcceptanceTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    private GuardianServices guardianServices;

    @Test
    void createATutor() throws Exception {
        String tutorRequestJson = """
            {
                "name": "Alice Johnson",
                "email": "alice.johnson@email.com",
                "phone": "987654321",
                "address": "123 Meadow Lane"
            }
        """;

        String expectedResponseJson = """
            {
                "id": 1,
                "name": "Alice Johnson",
                "email": "alice.johnson@email.com",
                "phone": "987654321",
                "address": "123 Meadow Lane"
            }
        """;

        mockMvc.perform(post("/api/clinic/guardian")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(tutorRequestJson)) // Enviamos el JSON manualmente como el cuerpo de la solicitud
                        .andExpect(status().isCreated());
                        //.andExpect(content().json(expectedResponseJson)); // Comparamos la respuesta con el JSON esperado


    }
}
