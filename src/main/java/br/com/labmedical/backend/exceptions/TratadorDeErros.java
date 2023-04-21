package br.com.labmedical.backend.exceptions;

import br.com.labmedical.backend.dtos.erros.ErroValidacaoDto;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class TratadorDeErros {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> entidadeNaoEncontrada(EntityNotFoundException e) {
        if (e.getMessage() != null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id informado não retornou nenhuma entidade.");
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ErroValidacaoDto>> badRequest(MethodArgumentNotValidException ex) {
        List<FieldError> erros = ex.getFieldErrors();

        return ResponseEntity.badRequest().body(
                erros.stream()
                        .map(ErroValidacaoDto::new)
                        .collect(Collectors.toList()));
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<String> typeMismatch(MethodArgumentTypeMismatchException e) {


        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body("mensagem: " + e.getMessage() + "\ncódigo de erro: " + e.getErrorCode());
    }

    @ExceptionHandler(EntidadeExistenteException.class)
    public ResponseEntity<String> usuarioJaExistente(EntidadeExistenteException e) {
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(e.getMessage());
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<String> naoEraLista(HttpMessageNotReadableException e) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body("Cuidados especificos e alergias devem estar em um array.\n" + e.getMessage());
    }

    @ExceptionHandler(GeneralException.class)
    public ResponseEntity<String> generoNaoCadastrado(GeneralException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

}
