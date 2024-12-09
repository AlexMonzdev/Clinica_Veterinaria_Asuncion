package com.example.ClinicaVeterinaria_Asuncion.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.Period;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String species;
    @Column
    private String breed;
    @Column
    private LocalDate birthDate;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "idTutor", nullable = false)
    private Tutor tutor;


    public int getAge() {
        if (birthDate == null) {
            return 0;
        }
        return Period.between(birthDate, LocalDate.now()).getYears();
    }


}
