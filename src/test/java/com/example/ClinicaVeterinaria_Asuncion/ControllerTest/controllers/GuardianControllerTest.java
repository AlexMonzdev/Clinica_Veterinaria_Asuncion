package com.example.ClinicaVeterinaria_Asuncion.ControllerTest.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import com.example.ClinicaVeterinaria_Asuncion.entities.Guardian;
import com.example.ClinicaVeterinaria_Asuncion.repositories.GuardianRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@AutoConfigureMockMvc
@SpringBootTest
public class GuardianControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    private GuardianRepository guardianRepository;

    @Test
    void getAllTutorsDataba_returnListGuardians() throws Exception {


        Guardian guardian1 = new Guardian();
        guardian1.setName("Jose");
        guardian1.setPhone("002323232");
        guardian1.setEmail("hose@gamil.com");
        guardian1.setAddress("C/ Melancolia 1");
        guardianRepository.save(guardian1);

        // WHEN: Realizar la solicitud GET al endpoint
        mockMvc.perform(get("/api/clinic/guardian")
                        .contentType(MediaType.APPLICATION_JSON))
                // THEN: Verificar que el código de estado es 200 OK
                .andExpect(status().isOk())
                // Verificar que el JSON contiene al menos un guardian con los datos correctos
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(jsonPath("$[0].name").value("Jose"))
                .andExpect(jsonPath("$[0].phone").value("002323232"))
                .andExpect(jsonPath("$[0].email").value("hose@gamil.com"))
                .andExpect(jsonPath("$[0].address").value("C/ Melancolia 1"));
    }


}
