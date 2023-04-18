package br.com.labmedical.backend.dtos.consulta;

public class ConsultaResponseDto {
    private Long id;
    private String motivoDaConsulta;
    private String horaEData;
    private String descricaoDoProblema;
    private String medicacaoReceitada;
    private String dosagensEPrecaucoes;

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
}
