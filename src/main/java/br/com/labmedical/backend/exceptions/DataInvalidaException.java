package br.com.labmedical.backend.exceptions;

public class DataInvalidaException extends RuntimeException {
    public DataInvalidaException() {
        super("Data inválida. Data deve estar no formato dd/MM/yyyy");
    }

    public DataInvalidaException(String message) {
        super(message);
    }
}
