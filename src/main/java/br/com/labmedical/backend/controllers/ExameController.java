package br.com.labmedical.backend.controllers;

import br.com.labmedical.backend.dtos.exame.ExamePostRequestDto;
import br.com.labmedical.backend.dtos.exame.ExameResponseDto;
import br.com.labmedical.backend.services.ExameService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/exames")
public class ExameController {
    @Autowired
    ExameService service;

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
}
