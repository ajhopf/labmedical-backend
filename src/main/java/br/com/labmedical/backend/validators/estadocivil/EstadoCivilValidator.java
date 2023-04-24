package br.com.labmedical.backend.validators.estadocivil;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class EstadoCivilValidator implements ConstraintValidator<EstadoCivil, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (Objects.isNull(value) || value.length() == 0) {
            return true;
        }

        List<String> estados = new ArrayList<>();

        estados.add("SOLTEIRO");
        estados.add("CASADO");
        estados.add("SEPARADO");
        estados.add("DIVORCIADO");
        estados.add("VIÚVO");

        return estados.contains(value.toUpperCase());
    }
}
