package br.com.labmedical.backend.validators.dob;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ FIELD })
@Retention(RUNTIME)
@Constraint(validatedBy = DobValidator.class)
@Documented
public @interface Dob {
    String message() default "Data deve estar no formato 'dd/MM/yyyy' e ser anterior ao dia atual.";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
