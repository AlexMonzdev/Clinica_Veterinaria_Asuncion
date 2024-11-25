package com.example.ClinicaVeterinaria_Asuncion;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table (name = "tutors")

public class Tutor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idNumber;
    private String name;
    private String associatedPatient;

    public Tutor(String name, long idNumber, String associatedPatient) {
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

    protected List<Tutor> findAll() {
        return List.of();
    }
}
