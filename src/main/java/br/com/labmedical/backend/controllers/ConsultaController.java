package br.com.labmedical.backend.controllers;

import br.com.labmedical.backend.dtos.consulta.ConsultaPostRequestDto;
import br.com.labmedical.backend.dtos.consulta.ConsultaResponseDto;
import br.com.labmedical.backend.services.ConsultaService;
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
@RequestMapping("/api/consultas")
public class ConsultaController {
    @Autowired
    ConsultaService service;

    @PostMapping
    public ResponseEntity<ConsultaResponseDto> cadastrarConsulta(
            @RequestBody @Valid ConsultaPostRequestDto requestDto,
            UriComponentsBuilder uriBuilder
            ) {
       ConsultaResponseDto consulta = service.cadastrarConsulta(requestDto);

       URI uri = uriBuilder.path("/api/consultas/{id}")
               .buildAndExpand(consulta.getId())
               .toUri();

       return ResponseEntity.created(uri).body(consulta);
    }

}
