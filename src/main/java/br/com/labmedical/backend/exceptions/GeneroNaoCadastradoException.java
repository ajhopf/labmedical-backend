package br.com.labmedical.backend.exceptions;

public class GeneroNaoCadastradoException extends GeneralException {
    public GeneroNaoCadastradoException() {
        super("Gênero não cadastrado na base de dados. O gênero deve ser 'feminino', 'masculino' ou 'outro'.");
    }
}
