package br.com.labmedical.backend.exceptions;

public class EnderecoNaoCadastradoException extends GeneralException {
//    public EnderecoNaoCadastradoException(){}
    public EnderecoNaoCadastradoException(Long enderecoId) {
        super("Endereço com id " + enderecoId + " não encontrado na base de dados.");
    }
}
