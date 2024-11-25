package com.example.ClinicaVeterinaria_Asuncion;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table (name = "tutors")

public class TutorRepository {
    private String name;
    private long idNumber;
    private String associatedPatient;

    public TutorRepository(String name, long idNumber, String associatedPatient) {
        this.name = name;
        this.idNumber = idNumber;
        this.associatedPatient = associatedPatient;
    }

    public String getName() {
        return name;
    }

    public long getIdNumber() {
        return idNumber;
    }

    public String getAssociatedPatient() {
        return associatedPatient;
    }
}
