package br.com.labmedical.backend.exceptions;

public class GeneralException extends RuntimeException {
    public GeneralException() {
    }

    public GeneralException(String message) {
        super(message);
    }
}
