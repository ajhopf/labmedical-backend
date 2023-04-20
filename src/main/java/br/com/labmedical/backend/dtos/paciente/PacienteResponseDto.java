package br.com.labmedical.backend.dtos.paciente;

import br.com.labmedical.backend.dtos.pessoa.PessoaPacienteResponseDto;
import br.com.labmedical.backend.models.Endereco;


public class PacienteResponseDto extends PessoaPacienteResponseDto {
    private String alergias;
    private String cuidadosEspecificos;
    private String contatoDeEmergencia;
    private String convenio;
    private String numeroConvenio;
    private String validadeConvenio;
    private Endereco endereco;
    private Integer consultas;
    private Integer exames;

    public String getAlergias() {
        return alergias;
    }

    public void setAlergias(String alergias) {
        this.alergias = alergias;
    }

    public String getCuidadosEspecificos() {
        return cuidadosEspecificos;
    }

    public void setCuidadosEspecificos(String cuidadosEspecificos) {
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

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Integer getConsultas() {
        return consultas;
    }

    public void setConsultas(Integer consultas) {
        this.consultas = consultas;
    }

    public Integer getExames() {
        return exames;
    }

    public void setExames(Integer exames) {
        this.exames = exames;
    }
}
