package br.com.labmedical.backend.models;

import jakarta.persistence.*;

@Entity
@Table(name = "consultas")
public class Consulta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, name = "motivo_da_consulta")
    private String motivoDaConsulta;
    @Column(nullable = false, name = "hora_e_data")
    private String horaEData;
    @Column(nullable = false, name = "descricao_do_problema")
    private String descricaoDoProblema;
    @Column(nullable = false, name = "medicacao_receitada")
    private String medicacaoReceitada;
    @Column(nullable = false, name = "dosagens_e_precaucoes")
    private String dosagensEPrecaucoes;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Paciente paciente;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Medico medico;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMotivoDaConsulta() {
        return motivoDaConsulta;
    }

    public void setMotivoDaConsulta(String motivoDaConsulta) {
        this.motivoDaConsulta = motivoDaConsulta;
    }

    public String getHoraEData() {
        return horaEData;
    }

    public void setHoraEData(String horaEData) {
        this.horaEData = horaEData;
    }

    public String getDescricaoDoProblema() {
        return descricaoDoProblema;
    }

    public void setDescricaoDoProblema(String descricaoDoProblema) {
        this.descricaoDoProblema = descricaoDoProblema;
    }

    public String getMedicacaoReceitada() {
        return medicacaoReceitada;
    }

    public void setMedicacaoReceitada(String medicacaoReceitada) {
        this.medicacaoReceitada = medicacaoReceitada;
    }

    public String getDosagensEPrecaucoes() {
        return dosagensEPrecaucoes;
    }

    public void setDosagensEPrecaucoes(String dosagensEPrecaucoes) {
        this.dosagensEPrecaucoes = dosagensEPrecaucoes;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }
}
