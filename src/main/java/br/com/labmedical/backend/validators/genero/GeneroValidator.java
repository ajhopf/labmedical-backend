package br.com.labmedical.backend.validators.genero;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GeneroValidator implements ConstraintValidator<Genero, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (Objects.isNull(value) || value.length() == 0) {
            return true;
        }

        List<String> generos = new ArrayList<>();

        generos.add("FEMININO");
        generos.add("MASCULINO");
        generos.add("OUTRO");

        return generos.contains(value.toUpperCase());
    }
}
