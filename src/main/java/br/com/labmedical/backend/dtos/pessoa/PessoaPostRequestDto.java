package br.com.labmedical.backend.dtos.pessoa;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public abstract class PessoaPostRequestDto {
    private String nomeCompleto;
    private String genero;
    @NotNull(message = "É necessário inserir uma data de nascimento.")
    private String dob;
//    @CPF
    private String cpf;
    private String rg;
    @NotNull (message = "É necessário inserir um estado civil.")
    private String estadoCivil;
    private String telefone;
    @NotNull (message = "É necessário inserir um email.")
    @Email
    private String email;
    private String naturalidade;

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNaturalidade() {
        return naturalidade;
    }

    public void setNaturalidade(String naturalidade) {
        this.naturalidade = naturalidade;
    }
}
