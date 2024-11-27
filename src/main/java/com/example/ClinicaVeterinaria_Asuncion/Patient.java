package com.example.ClinicaVeterinaria_Asuncion;

import jakarta.persistence.*;

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
    private int age;
    @ManyToOne
    @JoinColumn(name = "idTutor", nullable = false)
    private Tutor tutor;
    @Column
    private String species;


    public Patient(){

    }

    public Patient(Long id, String name, String gender, int age, Tutor tutor, String species) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.tutor = tutor;
        this.species = species;
    }

    public Object getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public Tutor getTutor() {
        return tutor;
    }

    public String getSpecies() {
        return species;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }
}
