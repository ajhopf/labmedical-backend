package br.com.labmedical.backend.models;

import jakarta.persistence.*;

@Entity
@Table(name = "cuidados_especificos")
public class CuidadoEspecifico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Paciente paciente;
    @Column(nullable = false, name = "cuidado_especifico")
    private String cuidadoEspecial;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public String getCuidadoEspecial() {
        return cuidadoEspecial;
    }

    public void setCuidadoEspecial(String cuidadoEspecial) {
        this.cuidadoEspecial = cuidadoEspecial;
    }
}
