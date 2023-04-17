package br.com.labmedical.backend.exceptions;

public class UsuarioExistenteException extends RuntimeException {
    public UsuarioExistenteException() {}

    public UsuarioExistenteException(String message) {
        super(message);
    }
}
