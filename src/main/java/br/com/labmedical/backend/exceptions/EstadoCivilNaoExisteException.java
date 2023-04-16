package br.com.labmedical.backend.exceptions;

public class EstadoCivilNaoExisteException extends RuntimeException {
    public EstadoCivilNaoExisteException() {
        super("Estado civil deve ser:\nSolteiro\n" +
                "Casado\n" +
                "Separado\n" +
                "Divorciado\n" +
                "Viúvo");
    }
}
