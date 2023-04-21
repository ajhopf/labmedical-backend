package br.com.labmedical.backend.dtos.paciente;

import br.com.labmedical.backend.dtos.pessoa.PessoaPutRequestDto;
import br.com.labmedical.backend.validators.datavalida.DataValida;

import java.util.List;

public class PacientePutRequestDto extends PessoaPutRequestDto {
    private List<String> alergias;
    private List<String> cuidadosEspecificos;
    private String contatoDeEmergencia;
    private String convenio;
    private String numeroConvenio;
    @DataValida
    private String validadeConvenio;
    private Long enderecoId;

    public List<String> getAlergias() {
        return alergias;
    }

    public void setAlergias(List<String> alergias) {
        this.alergias = alergias;
    }

    public List<String> getCuidadosEspecificos() {
        return cuidadosEspecificos;
    }

    public void setCuidadosEspecificos(List<String> cuidadosEspecificos) {
        this.cuidadosEspecificos = cuidadosEspecificos;
    }

    public String getContatoDeEmergencia() {
        return contatoDeEmergencia;
    }

    public void setContatoDeEmergencia(String contatoDeEmergencia) {
        this.contatoDeEmergencia = contatoDeEmergencia;
    }

    public String getConvenio() {
        return convenio;
    }

    public void setConvenio(String convenio) {
        this.convenio = convenio;
    }

    public String getNumeroConvenio() {
        return numeroConvenio;
    }

    public void setNumeroConvenio(String numeroConvenio) {
        this.numeroConvenio = numeroConvenio;
    }

    public String getValidadeConvenio() {
        return validadeConvenio;
    }

    public void setValidadeConvenio(String validadeConvenio) {
        this.validadeConvenio = validadeConvenio;
    }

    public Long getEnderecoId() {
        return enderecoId;
    }

    public void setEnderecoId(Long enderecoId) {
        this.enderecoId = enderecoId;
    }
}
