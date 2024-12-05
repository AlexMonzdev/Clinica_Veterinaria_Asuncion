package com.example.ClinicaVeterinaria_Asuncion.exceptions;

public class PatientNotFoundException extends RuntimeException{
    public PatientNotFoundException(String message){
        super(message);
    }

}
