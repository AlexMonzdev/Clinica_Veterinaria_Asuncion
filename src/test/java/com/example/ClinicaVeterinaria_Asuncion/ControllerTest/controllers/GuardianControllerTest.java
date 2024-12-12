package com.example.ClinicaVeterinaria_Asuncion.ControllerTest.controllers;

import com.example.ClinicaVeterinaria_Asuncion.dtos.GuardianRequestDTO;
import com.example.ClinicaVeterinaria_Asuncion.entities.Guardian;
import com.example.ClinicaVeterinaria_Asuncion.repositories.GuardianRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureMockMvc
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ActiveProfiles("test")
class GuardianControllerTest {

    @Autowired
    private GuardianRepository guardianRepository;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        guardianRepository.deleteAll();
    }

    @Test
    void givenGuardians_whenCallGetAllGuardians_thenReturnAListOfGuardians() throws Exception {
        Guardian guardian1 = Guardian.builder().name("ana").phone("123456789").email("john@gmail.com").address("123 Street").build();

        Guardian guardian2 = Guardian.builder().name("Maria").phone("123456789").email("john@gmail.com").address("123 Street").build();
        guardianRepository.save(guardian1);
        guardianRepository.save(guardian2);

        mockMvc.perform(get("/api/clinic/guardians")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].name", is("ana")))
                .andExpect(jsonPath("$[1].name", is("Maria")));
    }

    @Test
    void givenGuardianId_whenCallGetGuardianById_thenReturnGuardian() throws Exception {
        Guardian guardian = Guardian.builder().name("John").phone("123456789").email("john@gmail.com").address("123 Street").build();
        guardian = guardianRepository.save(guardian);

        mockMvc.perform(get("/api/clinic/guardians/" + guardian.getId())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is("John")))
                .andExpect(jsonPath("$.phone", is("123456789")))
                .andExpect(jsonPath("$.email", is("john@gmail.com")))
                .andExpect(jsonPath("$.address", is("123 Street")));
    }

    @Test
    void givenValidGuardian_whenAddGuardian_thenReturnCreated() throws Exception {
        GuardianRequestDTO guardianRequest = new GuardianRequestDTO("John", "john@gmail.com", "123456789", "123 Street");

        mockMvc.perform(post("/api/clinic/guardians")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(guardianRequest)))
                .andExpect(status().isCreated());
    }

    @Test
    void givenInvalidGuardian_whenAddGuardian_thenReturnBadRequest() throws Exception {
        GuardianRequestDTO invalidGuardian = new GuardianRequestDTO("", "", "john@gmail.com", "123 Street");

        mockMvc.perform(post("/api/clinic/guardians")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(invalidGuardian)))
                .andExpect(status().isBadRequest());
    }

    @Test
    void givenGuardianId_whenUpdateGuardian_thenReturnUpdatedGuardian() throws Exception {
        Guardian guardian = Guardian.builder().name("ana").phone("123456789").email("john@gmail.com").address("123 Street").build();
        guardian = guardianRepository.save(guardian);

        GuardianRequestDTO updatedGuardian = new GuardianRequestDTO("John Updated", "john_updated@gmail.com", "987654321", "456 Avenue");

        mockMvc.perform(put("/api/clinic/guardians/" + guardian.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(updatedGuardian)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is("John Updated")))
                .andExpect(jsonPath("$.phone", is("987654321")))
                .andExpect(jsonPath("$.email", is("john_updated@gmail.com")))
                .andExpect(jsonPath("$.address", is("456 Avenue")));
    }

    @Test
    void givenGuardianId_whenDeleteGuardian_thenReturnOk() throws Exception {
        Guardian guardian = Guardian.builder().name("ana").phone("123456789").email("john@gmail.com").address("123 Street").build();
        guardian = guardianRepository.save(guardian);

        mockMvc.perform(delete("/api/clinic/guardians/" + guardian.getId()))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Guardian deleted successfully")));
    }
}
