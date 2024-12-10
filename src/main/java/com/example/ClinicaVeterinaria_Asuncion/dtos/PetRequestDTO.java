package com.example.ClinicaVeterinaria_Asuncion.dtos;

import com.example.ClinicaVeterinaria_Asuncion.entities.Guardian;

import java.time.LocalDate;

public record PetRequestDTO(
   String name,
   String species,
   String breed,
   LocalDate birthDate,
   Guardian guardian
){}
