package br.com.labmedical.backend.validators.especializacao;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class EspecializacaoMedicaValidator implements ConstraintValidator<EspecializacaoMedica, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (Objects.isNull(value) || value.length() == 0) {
            return true;
        }

        List<String> especializacoes = new ArrayList<>();
        
        especializacoes.add("CLÍNICO GERAL");
        especializacoes.add("ANESTESISTA");
        especializacoes.add("DERMATOLOGISTA");
        especializacoes.add("GINECOLOGISTA");
        especializacoes.add("NEUROLOGISTA");
        especializacoes.add("PEDIATRA");
        especializacoes.add("PSIQUIATRA");
        especializacoes.add("ORTOPEDISTA");

        return especializacoes.contains(value.toUpperCase());
    }
}
