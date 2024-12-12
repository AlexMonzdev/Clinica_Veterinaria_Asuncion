package com.example.ClinicaVeterinaria_Asuncion.exceptions;

public class AppoinmentNotFoundException extends RuntimeException {
    public AppoinmentNotFoundException(String message) {
        super(message);
    }
}
