package com.example.ClinicaVeterinaria_Asuncion.controllers;

import com.example.ClinicaVeterinaria_Asuncion.dtos.StatisticsResponseDTO;
import com.example.ClinicaVeterinaria_Asuncion.services.StatisticsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/clinic/")
public class StatisticsController {

    private final StatisticsService statisticsService;

    public StatisticsController(StatisticsService statisticsService) {
        this.statisticsService = statisticsService;
    }

    @GetMapping("/statistics/global")
    public ResponseEntity<StatisticsResponseDTO> getGlobalStats(){
        StatisticsResponseDTO stats = statisticsService.countStats();
        return ResponseEntity.ok(stats);
    }


}
