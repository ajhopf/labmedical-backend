package br.com.labmedical.backend.validators.telefonevalido;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Objects;

public class TelefoneValidator implements ConstraintValidator<TelefoneValido, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (Objects.isNull(value) || value.length() == 0) {
            return true;
        }

        String telefoneApenasNumeros = value.replace("-", "");
        telefoneApenasNumeros = telefoneApenasNumeros.replace("(", "");
        telefoneApenasNumeros = telefoneApenasNumeros.replace(")", "");

        if (!telefoneApenasNumeros.matches("[0-9]+")) {
            return false;
        }

        if (telefoneApenasNumeros.length() < 10 || telefoneApenasNumeros.length() > 11) {
            return false;
        }


        if (value.contains("(") && value.contains(")")) {
            Integer primeiroParenteses = value.indexOf('(');
            Integer segundoParentese = value.indexOf(')');
            String ddd = value.substring(primeiroParenteses + 1, segundoParentese);
            if (ddd.length() > 2) {
                return false;
            }
            return true;
        } else {
            return false;
        }
    }
}
