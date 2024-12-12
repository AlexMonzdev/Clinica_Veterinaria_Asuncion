package com.example.ClinicaVeterinaria_Asuncion.services;

import com.example.ClinicaVeterinaria_Asuncion.dtos.AppointmentRequestDTO;
import com.example.ClinicaVeterinaria_Asuncion.dtos.AppointmentResponseDTO;
import com.example.ClinicaVeterinaria_Asuncion.entities.Appointment;
import com.example.ClinicaVeterinaria_Asuncion.entities.Guardian;
import com.example.ClinicaVeterinaria_Asuncion.entities.Pet;
import com.example.ClinicaVeterinaria_Asuncion.exceptions.AppoinmentNotFoundException;
import com.example.ClinicaVeterinaria_Asuncion.exceptions.GuardianNotFoundException;
import com.example.ClinicaVeterinaria_Asuncion.exceptions.PetNotFoundException;
import com.example.ClinicaVeterinaria_Asuncion.mappers.AppointmentMapper;
import com.example.ClinicaVeterinaria_Asuncion.mappers.GuardianMapper;
import com.example.ClinicaVeterinaria_Asuncion.repositories.AppointmentsRepository;
import com.example.ClinicaVeterinaria_Asuncion.repositories.PetRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentServices {

    private final AppointmentsRepository appointmentsRepository;
    private final PetRepository petRepository;

    public AppointmentServices(AppointmentsRepository appointmentsRepository,
                               PetRepository petRepository) {
        this.appointmentsRepository = appointmentsRepository;
        this.petRepository = petRepository;
    }

    public List<AppointmentResponseDTO> getAllAppointments() {
        List<Appointment> appointmentsList = appointmentsRepository.findAll();
        return appointmentsList.stream().map(AppointmentMapper::toResponse).toList();
    }

    public AppointmentResponseDTO createAppointment(AppointmentRequestDTO appointmentRequestDTO) {
        Pet pet = petRepository.findById(appointmentRequestDTO.petId())
                .orElseThrow(() -> new PetNotFoundException("Pet not found with id: " + appointmentRequestDTO.petId()));
        Appointment appointment = Appointment.builder()
                .localDate(appointmentRequestDTO.date())
                .localTime(appointmentRequestDTO.time())
                .reason(appointmentRequestDTO.reason())
                .pet(pet).build();

        Appointment saveAppointment = appointmentsRepository.save(appointment);
        return AppointmentMapper.toResponse(saveAppointment);
    }

    public AppointmentResponseDTO findById(Long id) {
        Appointment appointment = appointmentsRepository.findById(id)
                .orElseThrow(() -> new AppoinmentNotFoundException("Appointment not found with id: " + id));
        return AppointmentMapper.toResponse(appointment);
    }

    public void deleteById(Long id) {
        Appointment appointment = appointmentsRepository.findById(id)
                .orElseThrow(() -> new AppoinmentNotFoundException("Appointment not found with id: " + id));
        appointmentsRepository.delete(appointment);
    }

    public AppointmentResponseDTO updateAppointmentsServices(Long id, AppointmentRequestDTO appointmentRequestDTO) {
        Appointment appointment = appointmentsRepository.findById(id)
                .orElseThrow(() -> new AppoinmentNotFoundException("Appointment not found with id: " + id));

        Pet pet = petRepository.findById(appointmentRequestDTO.petId())
                .orElseThrow(() -> new PetNotFoundException("Pet not found with id: " + id));

        appointment.setLocalDate(appointmentRequestDTO.date());
        appointment.setLocalTime(appointmentRequestDTO.time());
        appointment.setReason(appointmentRequestDTO.reason());
        appointment.setPet(pet);
        Appointment appointmentResponse =  appointmentsRepository.save(appointment);

        return AppointmentMapper.toResponse(appointmentResponse);
    }
}

