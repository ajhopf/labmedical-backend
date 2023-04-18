package br.com.labmedical.backend.dtos.estatisticas;

public class EstatisticasDto {
    private Integer pacientes;
    private Integer consultas;
    private Integer exames;

    public EstatisticasDto(Integer pacientes, Integer consultas, Integer exames) {
        this.pacientes = pacientes;
        this.consultas = consultas;
        this.exames = exames;
    }

    public Integer getPacientes() {
        return pacientes;
    }

    public void setPacientes(Integer pacientes) {
        this.pacientes = pacientes;
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
