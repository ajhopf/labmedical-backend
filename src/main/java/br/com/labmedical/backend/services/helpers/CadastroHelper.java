package br.com.labmedical.backend.services.helpers;

import br.com.labmedical.backend.exceptions.EspecializacaoNaoExisteException;
import br.com.labmedical.backend.exceptions.EstadoCivilNaoExisteException;

import java.util.ArrayList;
import java.util.List;

public class CadastroHelper {
    public static void validarEstadoCivil(String estadoCivil) {
        List<String> estados = new ArrayList<>();

        estados.add("SOLTEIRO");
        estados.add("CASADO");
        estados.add("SEPARADO");
        estados.add("DIVORCIADO");
        estados.add("VIUVO");
        estados.add("VIÚVO");

        if (!estados.contains(estadoCivil.toUpperCase())) {
            throw new EstadoCivilNaoExisteException();
        }
    }

    public static void validarEspecializacao(String especializacao) {
        List<String> especializacoes = new ArrayList<>();

        especializacoes.add("CLINICO GERAL");
        especializacoes.add("CLÍNICO GERAL");
        especializacoes.add("ANESTESISTA");
        especializacoes.add("DERMATOLOGISTA");
        especializacoes.add("GINECOLOGISTA");
        especializacoes.add("NEUROLOGISTA");
        especializacoes.add("PEDIATRA");
        especializacoes.add("PSIQUIATRA");
        especializacoes.add("ORTOPEDISTA");

        if (!especializacoes.contains(especializacao.toUpperCase())) {
            throw new EspecializacaoNaoExisteException();
        };
    }
}
