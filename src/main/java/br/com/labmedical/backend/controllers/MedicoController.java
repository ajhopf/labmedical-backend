package br.com.labmedical.backend.controllers;

import br.com.labmedical.backend.dtos.medico.MedicoPostRequestDto;
import br.com.labmedical.backend.dtos.medico.MedicoResponseDto;
import br.com.labmedical.backend.services.MedicoService;
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
@RequestMapping("/api/usuarios")
public class MedicoController {
    @Autowired
    MedicoService service;

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
}
