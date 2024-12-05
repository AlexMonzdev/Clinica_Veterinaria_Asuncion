package com.example.ClinicaVeterinaria_Asuncion.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter
@Setter
public class Appointments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //petID
    @Column
    private LocalDate localDate;
    @Column
    private LocalTime localTime;
    @Column
    private String reason;
    @ManyToOne
    @JoinColumn(name = "idPatient", nullable = false)
    private Patient patient;

}
