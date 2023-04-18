package br.com.labmedical.backend.controllers;

import br.com.labmedical.backend.dtos.estatisticas.EstatisticasDto;
import br.com.labmedical.backend.services.EstatisticasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/estatisticas")
public class EstatisticasController {
    @Autowired
    EstatisticasService service;
    @GetMapping
    public ResponseEntity<EstatisticasDto> getAllEstatisticas() {
        EstatisticasDto estatisticas = service.getAllEstatisticas();

        return ResponseEntity.ok(estatisticas);
    }

}
