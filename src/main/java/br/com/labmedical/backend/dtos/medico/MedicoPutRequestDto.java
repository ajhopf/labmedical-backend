package br.com.labmedical.backend.dtos.medico;

import br.com.labmedical.backend.dtos.pessoa.PessoaPutRequestDto;

public class MedicoPutRequestDto extends PessoaPutRequestDto {
    private String crm;
    private String especializacao;
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
