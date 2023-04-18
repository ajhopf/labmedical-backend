package br.com.labmedical.backend.dtos.exame;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ExamePostRequestDto {
    @NotBlank
    private String nomeDoExame;
    @NotBlank
    private String tipoDoExame;
    @NotBlank
    private String laboratorio;
    private String arquivoDeExame;
    @NotBlank
    private String resultadoDoExame;
    @NotNull
    private Long pacienteId;

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

    public Long getPacienteId() {
        return pacienteId;
    }

    public void setPacienteId(Long pacienteId) {
        this.pacienteId = pacienteId;
    }
}
