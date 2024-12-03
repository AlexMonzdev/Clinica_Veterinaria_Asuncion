package com.example.ClinicaVeterinaria_Asuncion.exeptions;

public class PatientNotFoundException extends RuntimeException{
    public PatientNotFoundException(String message){
        super(message);
    }

}
