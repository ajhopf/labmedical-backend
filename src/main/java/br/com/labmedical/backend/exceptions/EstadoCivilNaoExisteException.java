package br.com.labmedical.backend.exceptions;

public class EstadoCivilNaoExisteException extends GeneralException {
    public EstadoCivilNaoExisteException() {
        super("Estado civil deve ser:\nSolteiro\n" +
                "Casado\n" +
                "Separado\n" +
                "Divorciado\n" +
                "Viúvo");
    }
}
