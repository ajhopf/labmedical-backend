package br.com.labmedical.backend.controllers;

import br.com.labmedical.backend.dtos.medico.UsuarioPostRequestDto;
import br.com.labmedical.backend.dtos.medico.UsuarioPutRequestDto;
import br.com.labmedical.backend.dtos.medico.UsuarioAtualizaSenhaDto;
import br.com.labmedical.backend.dtos.medico.UsuarioResponseDto;
import br.com.labmedical.backend.services.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
    @Autowired
    UsuarioService service;

    @GetMapping
    public ResponseEntity<List<UsuarioResponseDto>> getMedicos() {
        List<UsuarioResponseDto> medicos = service.getMedicos();

        return ResponseEntity.ok(medicos);
    }

    @PostMapping
    public ResponseEntity<UsuarioResponseDto> cadastrarMedico(
            @RequestBody @Valid UsuarioPostRequestDto requestDto,
            UriComponentsBuilder uriBuilder
            ) {
        UsuarioResponseDto medico = service.cadastrarMedico(requestDto);

        URI uri = uriBuilder.path("/api/usuarios/{id}")
                .buildAndExpand(medico.getId())
                .toUri();

        return ResponseEntity.created(uri).body(medico);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioResponseDto> atualizarMedico(
            @PathVariable Long id,
            @RequestBody @Valid UsuarioPutRequestDto requestDto
    ) {
        UsuarioResponseDto medico = service.atualizarMedico(id, requestDto);

        return ResponseEntity.ok(medico);
    }

    @PutMapping("/{id}/senha")
    public ResponseEntity<UsuarioResponseDto> atualizarSenha(
            @PathVariable Long id,
            @RequestBody @Valid UsuarioAtualizaSenhaDto senha
    ) {
        UsuarioResponseDto medico = service.atualizarSenha(id, senha);
        return ResponseEntity.ok(medico);
    }
}
