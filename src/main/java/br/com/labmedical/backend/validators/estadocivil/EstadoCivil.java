package br.com.labmedical.backend.validators.estadocivil;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ FIELD })
@Retention(RUNTIME)
@Constraint(validatedBy = EstadoCivilValidator.class)
@Documented
public @interface EstadoCivil {
    String message() default "Estado civil deve ser: 'Solteiro', 'Casado', 'Separado', 'Divorciado' ou 'Viúvo'.";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
