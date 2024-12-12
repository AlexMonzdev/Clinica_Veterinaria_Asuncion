package com.example.ClinicaVeterinaria_Asuncion.controllers;


import com.example.ClinicaVeterinaria_Asuncion.dtos.AppointmentRequestDTO;
import com.example.ClinicaVeterinaria_Asuncion.dtos.AppointmentResponseDTO;
import com.example.ClinicaVeterinaria_Asuncion.entities.Appointment;
import com.example.ClinicaVeterinaria_Asuncion.services.AppointmentServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clinic")
public class AppointmentsController {

    private final AppointmentServices appointmentServices;

    public AppointmentsController(AppointmentServices appointmentServices) {
        this.appointmentServices = appointmentServices;

    }

    @GetMapping("/appointments")
    public List<Appointment> getAllPatients() {
        return appointmentServices.findAll();
    }

    @PostMapping("/appointments")
    public ResponseEntity<AppointmentResponseDTO> addAppointments(@RequestBody AppointmentRequestDTO appointmentRequestDTO) {
      AppointmentResponseDTO appointment = appointmentServices.createAppointment(appointmentRequestDTO);
      return new ResponseEntity<>(appointment, HttpStatus.CREATED);
    }

    @DeleteMapping ("/appointments:id")
    public ResponseEntity<Appointment> deleteAppointments (@PathVariable Long id){
        appointmentServices.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

//    @PutMapping("/appointments:id")
//    public ResponseEntity<Appointment> updateAppointments(@PathVariable Long id, @RequestBody AppointmentRequestDTO appointmentRequestDTO) {
//        try {
//            Appointment updatedAppointment = appointmentServices.updateAppointmentsServices(id, appointmentRequestDTO);
//            Appointment updateAppointment = null;
//            Appointment updateAppointments = null;
//            return new ResponseEntity<>(updateAppointments, HttpStatus.OK);
//        } catch (RuntimeException e) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
    }

