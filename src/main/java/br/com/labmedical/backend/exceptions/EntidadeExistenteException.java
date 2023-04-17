package br.com.labmedical.backend.exceptions;

public class EntidadeExistenteException extends RuntimeException {
    public EntidadeExistenteException() {}

    public EntidadeExistenteException(String message) {
        super(message);
    }
}
