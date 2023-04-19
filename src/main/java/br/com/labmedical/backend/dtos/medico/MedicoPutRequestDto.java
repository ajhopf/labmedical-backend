package br.com.labmedical.backend.dtos.medico;

import br.com.labmedical.backend.dtos.pessoa.PessoaPutRequestDto;
import br.com.labmedical.backend.validators.especializacao.EspecializacaoMedica;

public class MedicoPutRequestDto extends PessoaPutRequestDto {
    private String crm;
    @EspecializacaoMedica
    private String especializacao;

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

}
