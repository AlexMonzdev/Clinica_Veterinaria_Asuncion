package com.example.ClinicaVeterinaria_Asuncion.controllers;


import com.example.ClinicaVeterinaria_Asuncion.dtos.AppointmentRequestDTO;
import com.example.ClinicaVeterinaria_Asuncion.dtos.AppointmentResponseDTO;
import com.example.ClinicaVeterinaria_Asuncion.dtos.GuardianResponseDTO;
import com.example.ClinicaVeterinaria_Asuncion.dtos.PetResponseDTO;
import com.example.ClinicaVeterinaria_Asuncion.entities.Appointment;
import com.example.ClinicaVeterinaria_Asuncion.exceptions.AppoinmentNotFoundException;
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
    public ResponseEntity<List<AppointmentResponseDTO>> getAllAppointments() {
        return ResponseEntity.ok(appointmentServices.getAllAppointments());
    }

    @GetMapping("/appointments/{id}")
    public ResponseEntity<AppointmentResponseDTO> getAppointmentById(@PathVariable Long id) {
        AppointmentResponseDTO appointmentResponseDTO = appointmentServices.findById(id);
        return ResponseEntity.ok(appointmentResponseDTO);
    }

    @PostMapping("/appointments")
    public ResponseEntity<AppointmentResponseDTO> addAppointments(@RequestBody AppointmentRequestDTO appointmentRequestDTO) {
        AppointmentResponseDTO appointment = appointmentServices.createAppointment(appointmentRequestDTO);
        return new ResponseEntity<>(appointment, HttpStatus.CREATED);
    }

    @DeleteMapping("/appointments{id}")
    public ResponseEntity<?> deleteAppointments(@PathVariable Long id) {
        appointmentServices.deleteById(id);
        return new ResponseEntity<>("Deleted successfully! ", HttpStatus.OK);
    }

    @PutMapping("/appointments{id}")
    public ResponseEntity<AppointmentResponseDTO> updateAppointments(@PathVariable Long id, @RequestBody AppointmentRequestDTO appointmentRequestDTO) {
       try{
           AppointmentResponseDTO updatedAppointment = appointmentServices.updateAppointmentsServices(id, appointmentRequestDTO);
           return ResponseEntity.ok(updatedAppointment);
       }catch (AppoinmentNotFoundException ex){
           return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
       }

    }

}