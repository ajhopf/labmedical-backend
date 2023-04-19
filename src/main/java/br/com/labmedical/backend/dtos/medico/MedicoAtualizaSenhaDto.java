package br.com.labmedical.backend.dtos.medico;

import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public class MedicoAtualizaSenhaDto {
    @NotNull(message = "Você deve informar um campo com o nome de 'senha' no corpo da requisição para atualizar a senha.")
    @Length(min = 8, message = "A nova senha deve ter pelo menos 8 caracteres.")
    private String senha;

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
