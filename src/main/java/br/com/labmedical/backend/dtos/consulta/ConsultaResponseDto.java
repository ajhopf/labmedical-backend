package br.com.labmedical.backend.dtos.consulta;

public class ConsultaResponseDto {
    private Long identificador;
    private String motivoDaConsulta;
    private String horaEData;
    private String descricaoDoProblema;
    private String medicacaoReceitada;
    private String dosagensEPrecaucoes;
    private Long indicador_paciente;
    private Long indicador_medico;

    public Long getIdentificador() {
        return identificador;
    }

    public void setIdentificador(Long identificador) {
        this.identificador = identificador;
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

    public Long getIndicador_paciente() {
        return indicador_paciente;
    }

    public void setIndicador_paciente(Long indicador_paciente) {
        this.indicador_paciente = indicador_paciente;
    }

    public Long getIndicador_medico() {
        return indicador_medico;
    }

    public void setIndicador_medico(Long indicador_medico) {
        this.indicador_medico = indicador_medico;
    }
}
