package br.com.labmedical.backend.exceptions;

public class EspecializacaoNaoExisteException extends GeneralException {
    public EspecializacaoNaoExisteException() {
        super("Especialização médica deve ser:\nClinico Geral\n" +
                "Anestesista\n" +
                "Dermatologista\n" +
                "Ginecologista\n" +
                "Neurologista\n" +
                "Pediatra\n" +
                "Psiquiatra\n" +
                "Ortopedista");
    }

}
