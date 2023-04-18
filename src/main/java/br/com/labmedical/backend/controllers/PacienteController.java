package br.com.labmedical.backend.controllers;

import br.com.labmedical.backend.dtos.paciente.PacientePostRequestDto;
import br.com.labmedical.backend.dtos.paciente.PacientePutRequestDto;
import br.com.labmedical.backend.dtos.paciente.PacienteResponseDto;
import br.com.labmedical.backend.services.PacienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/pacientes")
public class PacienteController {
    @Autowired
    PacienteService service;

    @GetMapping
    public ResponseEntity<List<PacienteResponseDto>> getPacientes(
            @RequestParam(required = false) String nome
    ) {
        List<PacienteResponseDto> pacientes = service.getPacientes(nome);

        return ResponseEntity.ok(pacientes);
    }

    @GetMapping("/{identificador}")
    public ResponseEntity<PacienteResponseDto> getPacienteById(
            @PathVariable Long identificador
    ) {
        PacienteResponseDto paciente = service.getPacienteById(identificador);

        return ResponseEntity.ok(paciente);
    }

    @PostMapping
    public ResponseEntity<PacienteResponseDto> cadastrarPaciente(
            @RequestBody @Valid PacientePostRequestDto requestDto,
            UriComponentsBuilder uriBuilder
            ) {
        PacienteResponseDto paciente = service.cadastrarPaciente(requestDto);

        URI uri = uriBuilder.path("/api/pacientes/{id}")
                .buildAndExpand(paciente.getIdentificador())
                .toUri();

        return ResponseEntity.created(uri).body(paciente);
    }

    @PutMapping("/{identificador}")
    public ResponseEntity<PacienteResponseDto> atualizarPaciente(
            @PathVariable Long identificador,
            @RequestBody @Valid PacientePutRequestDto requestDto
    ) {
        PacienteResponseDto paciente = service.atualizarPaciente(identificador, requestDto);

        return ResponseEntity.ok(paciente);
    }

    @DeleteMapping("/{identificador}")
    public ResponseEntity<Void> deletarPaciente(
            @PathVariable Long identificador
    ) {
        service.deletarPaciente(identificador);

        return ResponseEntity.noContent().build();
    }

}
