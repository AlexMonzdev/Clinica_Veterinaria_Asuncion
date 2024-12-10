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

    @GetMapping("/appointment")
    public List<Appointments> getAllPatients() {
        return appointmentsServices.findAll();
    }

    @PostMapping("/appointment")
    public ResponseEntity<AppointmentsRequestDTO> addAppointments(@RequestBody AppointmentsRequestDTO appointmentsRequestDTO) {

      appointmentsServices.createAppointmentServices(appointmentsRequestDTO);
      return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping ("/appointment/{id}")
    public ResponseEntity<Appointments> getAppointmentsById(@PathVariable Long id) {
        Optional<Appointments> optionalAppointments = appointmentsServices.findById(id);
        if (optionalAppointments.isPresent()){
            return new ResponseEntity<>(optionalAppointments.get() , HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping ("/appointment/{id}")
    public ResponseEntity<Appointments> deleteAppointments (@PathVariable Long id){
        appointmentsServices.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/appointment/{id}")
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
