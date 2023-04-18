package br.com.labmedical.backend.dtos.pessoa;

import br.com.labmedical.backend.validators.dob.Dob;
import br.com.labmedical.backend.validators.estadocivil.EstadoCivil;
import br.com.labmedical.backend.validators.genero.Genero;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

public abstract class PessoaPostRequestDto {
    private String nomeCompleto;
    @Genero
    private String genero;
    @NotBlank(message = "É necessário inserir uma data de nascimento.")
    @Dob
    private String dob;
    @CPF
    private String cpf;
    private String rg;
    @NotBlank(message = "É necessário inserir um estado civil.")
    @EstadoCivil
    private String estadoCivil;
    private String telefone;
    @NotBlank (message = "É necessário inserir um email.")
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
