package br.com.labmedical.backend.exceptions;

public class GeneroNaoCadastradoException extends RuntimeException {
    public GeneroNaoCadastradoException() {
        super("Gênero não cadastrado na base de dados. O gênero deve ser 'feminino', 'masculino' ou 'outro'.");
    }
}
