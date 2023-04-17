package br.com.labmedical.backend.exceptions;

import br.com.labmedical.backend.dtos.erros.ErroValidacaoDto;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class TratadorDeErros {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Void> entidadeNaoEncontrada() {
        return
                ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ErroValidacaoDto>> badRequest(MethodArgumentNotValidException ex) {
        List<FieldError> erros = ex.getFieldErrors();

        return ResponseEntity.badRequest().body(
                erros.stream()
                        .map(ErroValidacaoDto::new)
                        .collect(Collectors.toList()));
    }

    @ExceptionHandler(UsuarioExistenteException.class)
    public ResponseEntity<String> usuarioJaExistente(UsuarioExistenteException e) {
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(e.getMessage());
    }

    @ExceptionHandler(GeneralException.class)
    public ResponseEntity<String> generoNaoCadastrado(GeneralException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

}
