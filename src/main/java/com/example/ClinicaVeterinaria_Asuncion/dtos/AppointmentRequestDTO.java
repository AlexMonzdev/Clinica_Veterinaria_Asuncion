package com.example.ClinicaVeterinaria_Asuncion.dtos;

import com.example.ClinicaVeterinaria_Asuncion.entities.Pet;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.time.LocalTime;

public record AppointmentRequestDTO(
        @NotNull(message = "Date cannot be null")
        @FutureOrPresent(message = "Date must be in the present or future")
        LocalDate date,

        @NotNull(message = "Time cannot be null")
        LocalTime time,

        @NotBlank(message = "Reason cannot be empty")
        @Size(min = 5, max = 255, message = "Reason must be between 5 and 255 characters")
        String reason,

        @NotNull(message = "Pet cannot be null")
        Long petId
){
}
