package com.example.ClinicaVeterinaria_Asuncion.entities;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
    private Pet pet;

}
