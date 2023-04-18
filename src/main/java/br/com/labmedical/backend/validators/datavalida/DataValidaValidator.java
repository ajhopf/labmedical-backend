package br.com.labmedical.backend.validators.datavalida;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.apache.commons.validator.GenericValidator;

import java.util.Objects;

public class DataValidaValidator implements ConstraintValidator<DataValida, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (Objects.isNull(value) || value.length() == 0) {
            return true;
        }

        return GenericValidator.isDate(value, "dd/MM/yyyy", true);
    }
}
