package com.example.ClinicaVeterinaria_Asuncion.controllers;


import com.example.ClinicaVeterinaria_Asuncion.dtos.AppointmentsRequestDTO;
import com.example.ClinicaVeterinaria_Asuncion.entities.Appointments;
import com.example.ClinicaVeterinaria_Asuncion.services.AppointmentsServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/clinic")
public class AppointmentsController {

    private final AppointmentsServices appointmentsServices;

    public AppointmentsController(AppointmentsServices appointmentsServices) {
        this.appointmentsServices = appointmentsServices;

    }

    @GetMapping("/appointments")
    public List<Appointments> getAllPatients() {
        return appointmentsServices.findAll();
    }

    @PostMapping("/appointments")
    public ResponseEntity<AppointmentsRequestDTO> addAppointments(@RequestBody AppointmentsRequestDTO appointmentsRequestDTO) {

      appointmentsServices.createAppointmentServices(appointmentsRequestDTO);
      return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping ("/appointments:id")
    public ResponseEntity<Appointments> deleteAppointments (@PathVariable Long id){
        appointmentsServices.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/appointments:id")
    public ResponseEntity<Appointments> updateAppointments(@PathVariable Long id, @RequestBody AppointmentsRequestDTO appointmentsRequestDTO) {
        try {
            Appointments updatedAppointment = appointmentsServices.updateAppointmentsServices(id, appointmentsRequestDTO);
            Appointments updateAppointment = null;
            Appointments updateAppointments = null;
            return new ResponseEntity<>(updateAppointments, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
