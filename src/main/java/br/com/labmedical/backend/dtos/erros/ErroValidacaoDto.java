package br.com.labmedical.backend.dtos.erros;

import org.springframework.validation.FieldError;

public class ErroValidacaoDto {
    private final String campo;
    private final String mensagem;

    public ErroValidacaoDto(FieldError erro) {
        this.campo = erro.getField();
        this.mensagem = erro.getDefaultMessage();
    }

    public String getCampo() {
        return campo;
    }

    public String getMensagem() {
        return mensagem;
    }
}
