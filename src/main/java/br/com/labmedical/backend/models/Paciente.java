package br.com.labmedical.backend.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "pacientes")
public class Paciente extends Pessoa{
    private String alergias;
    @Column(name = "cuidados_especificos")
    private String cuidadosEspecificos;
    @Column(nullable = false, name = "contato_de_emergencia")
    private String contatoDeEmergencia;
    private String convenio;
    @Column(name = "numero_convenio")
    private String numeroConvenio;
    @Column(name = "validade_convenio")
    private String validadeConvenio;
    @ManyToOne
    private Endereco Endereco;

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

    public br.com.labmedical.backend.models.Endereco getEndereco() {
        return Endereco;
    }

    public void setEndereco(br.com.labmedical.backend.models.Endereco endereco) {
        Endereco = endereco;
    }
}
