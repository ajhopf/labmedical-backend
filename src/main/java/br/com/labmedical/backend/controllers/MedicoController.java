package br.com.labmedical.backend.controllers;

import br.com.labmedical.backend.dtos.medico.MedicoPostRequestDto;
import br.com.labmedical.backend.dtos.medico.MedicoPutRequestDto;
import br.com.labmedical.backend.dtos.medico.MedicoResponseDto;
import br.com.labmedical.backend.services.MedicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class MedicoController {
    @Autowired
    MedicoService service;

    @GetMapping
    public ResponseEntity<List<MedicoResponseDto>> getMedicos() {
        List<MedicoResponseDto> medicos = service.getMedicos();

        return ResponseEntity.ok(medicos);
    }

    @PostMapping
    public ResponseEntity<MedicoResponseDto> cadastrarMedico(
            @RequestBody @Valid MedicoPostRequestDto requestDto,
            UriComponentsBuilder uriBuilder
            ) {
        MedicoResponseDto medico = service.cadastrarMedico(requestDto);

        URI uri = uriBuilder.path("/api/usuarios/{id}")
                .buildAndExpand(medico.getId())
                .toUri();

        return ResponseEntity.created(uri).body(medico);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MedicoResponseDto> atualizarMedico(
            @PathVariable Long id,
            @RequestBody @Valid MedicoPutRequestDto requestDto
    ) {
        MedicoResponseDto medico = service.atualizarMedico(id, requestDto);

        return ResponseEntity.ok(medico);
    }
}
