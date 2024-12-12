package com.example.ClinicaVeterinaria_Asuncion.mappers;

import com.example.ClinicaVeterinaria_Asuncion.dtos.*;
import com.example.ClinicaVeterinaria_Asuncion.entities.Appointment;
import com.example.ClinicaVeterinaria_Asuncion.entities.Pet;

public class AppointmentMapper {

    public static Appointment toEntity(AppointmentRequestDTO appointmentRequestDTO) {
        Pet pet = Pet.builder().id(appointmentRequestDTO.petId()).build();
        return Appointment.builder()
                .localDate(appointmentRequestDTO.date())
                .localTime(appointmentRequestDTO.time())
                .reason(appointmentRequestDTO.reason())
                .pet(pet)
                .build();

    }

    public static AppointmentResponseDTO toResponse(Appointment appointment) {
        return AppointmentResponseDTO.builder()
                .id(appointment.getId())
                .date(appointment.getLocalDate())
                .time(appointment.getLocalTime())
                .reason(appointment.getReason())
                .pet(appointment.getPet())
                .build();
    }


}
