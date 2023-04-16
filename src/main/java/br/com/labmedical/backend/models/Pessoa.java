package br.com.labmedical.backend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Entity
public abstract class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeCompleto;
    private String genero;
    @NotNull
    private LocalDate dob;
    private String cpf;
    private String rg;
    //Opções:
    //Solteiro
    //Casado
    //Separado
    //Divorciado
    //Viúvo
    @NotNull
    private String estadoCivil;
    private String telefone;
    @Email
    private String email;
    private String naturalidade;
}
