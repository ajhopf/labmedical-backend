package br.com.labmedical.backend.controllers;

import br.com.labmedical.backend.dtos.endereco.EnderecoPostRequestDto;
import br.com.labmedical.backend.dtos.endereco.EnderecoResponseDto;
import br.com.labmedical.backend.services.EnderecoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/enderecos")
public class EnderecoController {

    @Autowired
    EnderecoService service;

    @GetMapping
    public ResponseEntity<List<EnderecoResponseDto>> getEnderecos() {
        List<EnderecoResponseDto> enderecos = service.getEnderecos();

        return ResponseEntity.ok(enderecos);
    }

    @PostMapping
    public ResponseEntity<EnderecoResponseDto> cadastrarEndereco(
            @RequestBody @Valid EnderecoPostRequestDto requestDto,
            UriComponentsBuilder uriBuilder
            ) {
        EnderecoResponseDto endereco = service.cadastrarEndereco(requestDto);

        URI uri = uriBuilder.path("/api/enderecos/{id}")
                .buildAndExpand(endereco.getId())
                .toUri();

        return ResponseEntity.created(uri).body(endereco);
    }
}
