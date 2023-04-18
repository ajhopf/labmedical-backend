package br.com.labmedical.backend.dtos.consulta;

import jakarta.validation.constraints.NotBlank;

public class ConsultaPostRequestDto {
    @NotBlank
    private String motivoDaConsulta;
//    @NotBlank
//    private String horaEData;
    @NotBlank
    private String descricaoDoProblema;
    @NotBlank
    private String medicacaoReceitada;
    @NotBlank
    private String dosagensEPrecaucoes;

    public String getMotivoDaConsulta() {
        return motivoDaConsulta;
    }

    public void setMotivoDaConsulta(String motivoDaConsulta) {
        this.motivoDaConsulta = motivoDaConsulta;
    }

//    public String getHoraEData() {
//        return horaEData;
//    }
//
//    public void setHoraEData(String horaEData) {
//        this.horaEData = horaEData;
//    }

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
