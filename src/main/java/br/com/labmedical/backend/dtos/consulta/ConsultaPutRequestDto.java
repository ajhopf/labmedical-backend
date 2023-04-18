package br.com.labmedical.backend.dtos.consulta;

public class ConsultaPutRequestDto {
    private String motivoDaConsulta;
    private String descricaoDoProblema;
    private String medicacaoReceitada;
    private String dosagensEPrecaucoes;
    private Long pacienteId;

    public String getMotivoDaConsulta() {
        return motivoDaConsulta;
    }

    public void setMotivoDaConsulta(String motivoDaConsulta) {
        this.motivoDaConsulta = motivoDaConsulta;
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

    public Long getPacienteId() {
        return pacienteId;
    }

    public void setPacienteId(Long pacienteId) {
        this.pacienteId = pacienteId;
    }
}
