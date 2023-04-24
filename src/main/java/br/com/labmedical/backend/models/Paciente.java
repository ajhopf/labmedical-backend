package br.com.labmedical.backend.models;

import jakarta.persistence.*;

@Entity
@Table(name = "pacientes")
public class Paciente extends Pessoa{
    @Column(nullable = false, name = "contato_de_emergencia")
    private String contatoDeEmergencia;
    private String convenio;
    @Column(name = "numero_convenio")
    private String numeroConvenio;
    @Column(name = "validade_convenio")
    private String validadeConvenio;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Endereco Endereco;

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
