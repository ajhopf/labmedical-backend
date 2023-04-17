package br.com.labmedical.backend.validators.dob;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.apache.commons.validator.GenericValidator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class DobValidator implements ConstraintValidator<Dob, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (Objects.isNull(value) || value.length() == 0) {
            return true;
        }

        if (GenericValidator.isDate(value, "dd/MM/yyyy", true)) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate dob = LocalDate.parse(value, formatter);
            LocalDate now = LocalDate.now();
            return !dob.isAfter(now);
        }

        return false;
    }
}
