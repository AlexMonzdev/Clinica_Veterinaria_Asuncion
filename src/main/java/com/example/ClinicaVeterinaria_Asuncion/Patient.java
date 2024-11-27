package com.example.ClinicaVeterinaria_Asuncion;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;


@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String gender;
    @Column
    private LocalDate birthDate;
    @ManyToOne
    @JoinColumn(name = "idTutor", nullable = false)
    private Tutor tutor;
    @Column
    private String species;


    public Patient(){

    }

    public Patient(String name, String gender, LocalDate birthDate, Tutor tutor, String species) {
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.tutor = tutor;
        this.species = species;
    }

    public int getAge() {
        if (birthDate == null) {
            return 0;
        }
        return Period.between(birthDate, LocalDate.now()).getYears();
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Tutor getTutor() {
        return tutor;
    }

    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }
}
