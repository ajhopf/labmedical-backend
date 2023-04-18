package br.com.labmedical.backend.controllers;

import br.com.labmedical.backend.dtos.consulta.ConsultaPostRequestDto;
import br.com.labmedical.backend.dtos.consulta.ConsultaPutRequestDto;
import br.com.labmedical.backend.dtos.consulta.ConsultaResponseDto;
import br.com.labmedical.backend.dtos.exame.ExameResponseDto;
import br.com.labmedical.backend.services.ConsultaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/consultas")
public class ConsultaController {
    @Autowired
    ConsultaService service;

    @GetMapping("/{identificador}")
    public ResponseEntity<ConsultaResponseDto> getConsulta(
            @PathVariable Long identificador
    ) {
        ConsultaResponseDto consulta = service.getConsulta(identificador);

        return ResponseEntity.ok(consulta);
    }

    @PostMapping
    public ResponseEntity<ConsultaResponseDto> cadastrarConsulta(
            @RequestBody @Valid ConsultaPostRequestDto requestDto,
            UriComponentsBuilder uriBuilder
            ) {
       ConsultaResponseDto consulta = service.cadastrarConsulta(requestDto);

       URI uri = uriBuilder.path("/api/consultas/{id}")
               .buildAndExpand(consulta.getIdentificador())
               .toUri();

       return ResponseEntity.created(uri).body(consulta);
    }

    @PutMapping("/{identificador}")
    public ResponseEntity<ConsultaResponseDto> atualizarConsulta(
            @PathVariable Long identificador,
            @RequestBody ConsultaPutRequestDto requestDto
            ) {
        ConsultaResponseDto consulta = service.atualizarConsulta(identificador, requestDto);

        return ResponseEntity.ok(consulta);
    }

    @DeleteMapping("/{identificador}")
    public ResponseEntity<Void> deletarConsulta(
            @PathVariable Long identificador
    ) {
        service.deletarConsulta(identificador);

        return ResponseEntity.noContent().build();
    }
}
