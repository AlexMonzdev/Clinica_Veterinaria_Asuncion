package com.example.ClinicaVeterinaria_Asuncion.services;

import com.example.ClinicaVeterinaria_Asuncion.dtos.AppointmentsRequestDTO;
import com.example.ClinicaVeterinaria_Asuncion.entities.Appointments;
import com.example.ClinicaVeterinaria_Asuncion.repositories.AppointmentsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentsServices {
    private final AppointmentsRepository appointmentsRepository;

    public AppointmentsServices(AppointmentsRepository appointmentsRepository) {
        this.appointmentsRepository = appointmentsRepository;
    }

    public List<Appointments> findAll() {
        return appointmentsRepository.findAll();
    }

    public void createAppointmentServices(AppointmentsRequestDTO appointmentsRequestDTO) {
        Appointments appointments = new Appointments();
        appointments.setLocalDate(appointmentsRequestDTO.date());
        appointments.setLocalTime(appointmentsRequestDTO.time());
        appointments.setReason(appointmentsRequestDTO.reason());
        appointments.setPatient(appointmentsRequestDTO.patient());
        appointmentsRepository.save(appointments);
    }

    public Optional<Appointments> findById(Long id) {
        return appointmentsRepository.findById(id);
    }

    public void deleteById(Long id) {
        Appointments appointments = appointmentsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Appointment not found with id: " + id));
        appointmentsRepository.delete(appointments);
    }

    public Appointments updateAppointmentsServices(Long id, AppointmentsRequestDTO appointmentsRequestDTO) {
            Appointments appointments = appointmentsRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Tutor not found with id: " + id));

            appointments.setLocalDate(appointmentsRequestDTO.date());
            appointments.setLocalTime(appointmentsRequestDTO.time());
            appointments.setReason(appointmentsRequestDTO.reason());
            appointments.setPatient(appointmentsRequestDTO.patient());
           return appointmentsRepository.save(appointments);
        }
    }

