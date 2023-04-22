package br.com.labmedical.backend.models;

import jakarta.persistence.*;

@Entity
@Table(name = "exames")
public class Exame {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, name = "nome_do_exame")
    private String nomeDoExame;
    @Column(nullable = false, name = "hora_e_data")
    private String horaEData;
    @Column(nullable = false, name = "tipo_do_exame")
    private String tipoDoExame;
    @Column(nullable = false)
    private String laboratorio;
    @Column(name = "arquivo_de_exame")
    private String arquivoDeExame;
    @Column(nullable = false, name = "resultado_do_exame")
    private String resultadoDoExame;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Paciente paciente;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Usuario usuario;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeDoExame() {
        return nomeDoExame;
    }

    public void setNomeDoExame(String nomeDoExame) {
        this.nomeDoExame = nomeDoExame;
    }

    public String getHoraEData() {
        return horaEData;
    }

    public void setHoraEData(String horaEData) {
        this.horaEData = horaEData;
    }

    public String getTipoDoExame() {
        return tipoDoExame;
    }

    public void setTipoDoExame(String tipoDoExame) {
        this.tipoDoExame = tipoDoExame;
    }

    public String getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(String laboratorio) {
        this.laboratorio = laboratorio;
    }

    public String getArquivoDeExame() {
        return arquivoDeExame;
    }

    public void setArquivoDeExame(String arquivoDeExame) {
        this.arquivoDeExame = arquivoDeExame;
    }

    public String getResultadoDoExame() {
        return resultadoDoExame;
    }

    public void setResultadoDoExame(String resultadoDoExame) {
        this.resultadoDoExame = resultadoDoExame;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Usuario getMedico() {
        return usuario;
    }

    public void setMedico(Usuario usuario) {
        this.usuario = usuario;
    }
}
