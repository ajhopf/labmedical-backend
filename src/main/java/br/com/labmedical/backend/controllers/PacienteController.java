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
            @RequestParam String nome
    ) {
        List<PacienteResponseDto> pacientes = service.getPacientes(nome);

        return ResponseEntity.ok(pacientes);
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

    @PutMapping("/{id}")
    public ResponseEntity<PacienteResponseDto> atualizarPaciente(
            @PathVariable Long id,
            @RequestBody @Valid PacientePutRequestDto requestDto
    ) {
        PacienteResponseDto paciente = service.atualizarPaciente(id, requestDto);

        return ResponseEntity.ok(paciente);
    }
}
