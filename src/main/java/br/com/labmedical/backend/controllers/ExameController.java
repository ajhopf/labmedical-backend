package br.com.labmedical.backend.controllers;

import br.com.labmedical.backend.dtos.exame.ExamePostRequestDto;
import br.com.labmedical.backend.dtos.exame.ExamePutRequestDto;
import br.com.labmedical.backend.dtos.exame.ExameResponseDto;
import br.com.labmedical.backend.services.ExameService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/exames")
public class ExameController {
    @Autowired
    ExameService service;

    @GetMapping("/{identificador}")
    public ResponseEntity<ExameResponseDto> getExame(
            @PathVariable Long identificador
    ) {
        ExameResponseDto exame = service.getExame(identificador);

        return ResponseEntity.ok(exame);
    }

    @PostMapping
    public ResponseEntity<ExameResponseDto> cadastrarExame(
            @RequestBody @Valid ExamePostRequestDto requestDto,
            UriComponentsBuilder uriBuilder
            ) {
        ExameResponseDto exame = service.cadastrarExame(requestDto);

        URI uri = uriBuilder.path("/api/usuarios/{id}")
                .buildAndExpand(exame.getIdentificador())
                .toUri();

        return ResponseEntity.created(uri).body(exame);
    }

    @PutMapping("/{identificador}")
    public ResponseEntity<ExameResponseDto> atualizarExame(
            @PathVariable Long identificador,
            @RequestBody ExamePutRequestDto requestDto
    ) {
        ExameResponseDto exame = service.atualizarExame(identificador, requestDto);

        return ResponseEntity.ok(exame);
    }

    @DeleteMapping("/{identificador}")
    public ResponseEntity<Void> deletarExame(
            @PathVariable Long identificador
    ) {
        service.deletarExame(identificador);

        return ResponseEntity.noContent().build();
    }

}
