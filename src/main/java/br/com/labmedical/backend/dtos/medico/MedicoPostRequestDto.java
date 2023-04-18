package br.com.labmedical.backend.dtos.medico;

import br.com.labmedical.backend.dtos.pessoa.PessoaPostRequestDto;
import br.com.labmedical.backend.validators.especializacao.EspecializacaoMedica;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public class MedicoPostRequestDto extends PessoaPostRequestDto {
    @NotBlank(message = "É necessário inserir o registro CRM.")
    private String crm;
    @NotBlank (message = "É necessário inserir uma especialização médica.")
    @EspecializacaoMedica
    private String especializacao;

    @Length(min = 8, message = "A senha deve ter pelo menos 8 caracteres.")
    private String senha;

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public String getEspecializacao() {
        return especializacao;
    }

    public void setEspecializacao(String especializacao) {
        this.especializacao = especializacao;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
