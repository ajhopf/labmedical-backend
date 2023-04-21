package br.com.labmedical.backend.dtos.exame;

public class ExameResponseDto {
    private Long identificador;
    private String nomeDoExame;
    private String tipoDoExame;
    private String horaEData;
    private String laboratorio;
    private String arquivoDeExame;
    private String resultadoDoExame;
    private Long indicador_paciente;
    private Long indicador_medico;

    public Long getIdentificador() {
        return identificador;
    }

    public void setIdentificador(Long identificador) {
        this.identificador = identificador;
    }

    public String getNomeDoExame() {
        return nomeDoExame;
    }

    public void setNomeDoExame(String nomeDoExame) {
        this.nomeDoExame = nomeDoExame;
    }

    public String getTipoDoExame() {
        return tipoDoExame;
    }

    public void setTipoDoExame(String tipoDoExame) {
        this.tipoDoExame = tipoDoExame;
    }

    public String getHoraEData() {
        return horaEData;
    }

    public void setHoraEData(String horaEData) {
        this.horaEData = horaEData;
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
