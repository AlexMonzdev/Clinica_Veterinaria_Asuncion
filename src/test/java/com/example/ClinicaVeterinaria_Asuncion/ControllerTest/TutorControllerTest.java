package com.example.ClinicaVeterinaria_Asuncion.ControllerTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import com.example.ClinicaVeterinaria_Asuncion.Entities.Tutor;
import com.example.ClinicaVeterinaria_Asuncion.Repositories.TutorRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

@AutoConfigureMockMvc
@SpringBootTest
public class TutorControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    private TutorRepository tutorRepository;

    @Test
    void getAllTutorsDataba_returnListTutors() throws Exception {


        Tutor tutor1 = new Tutor();
        tutor1.setFirstname("Jose");
        tutor1.setLastname("Gonzalez");
        tutor1.setPhoneNumber(1234);
        tutorRepository.save(tutor1);

        // WHEN: Realizar la solicitud GET al endpoint
        mockMvc.perform(get("/api/clinic/tutor")
                        .contentType(MediaType.APPLICATION_JSON))
                // THEN: Verificar que el código de estado es 200 OK
                .andExpect(status().isOk())
                // Verificar que el JSON contiene al menos un tutor con los datos correctos
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(jsonPath("$[0].firstname").value("Jose"))
                .andExpect(jsonPath("$[0].lastname").value("Gonzalez"))
                .andExpect(jsonPath("$[0].phoneNumber").value(1234));
    }


}
