package com.example.ClinicaVeterinaria_Asuncion;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table (name = "tutors")

public class Tutor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private long idNumber;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String associatedPatient;
    @Column(nullable = false)
    private boolean hasPatient;

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
