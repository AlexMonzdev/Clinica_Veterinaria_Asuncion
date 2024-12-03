package com.example.ClinicaVeterinaria_Asuncion.dtos;

import com.example.ClinicaVeterinaria_Asuncion.entities.Tutor;

import java.time.LocalDate;

public record PatienRequestDTO (
   String name,
   String species,
   String breed,
   LocalDate birthDate,
   Tutor tutor
){}
