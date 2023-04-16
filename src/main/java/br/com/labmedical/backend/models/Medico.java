package br.com.labmedical.backend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "medicos")
public class Medico extends Pessoa {
    private String crm;
    private String especializacao;
    //Clínico Geral
    //Anestesista
    //Dermatologia
    //Ginecologia
    //Neurologia
    //Pediatria
    //Psiquiatria
    //Ortopedia
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
