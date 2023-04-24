package br.com.labmedical.backend.validators.telefonevalido;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ FIELD })
@Retention(RUNTIME)
@Constraint(validatedBy = TelefoneValidator.class)
@Documented
public @interface TelefoneValido {
    String message() default "Telefone deve estar nos seguintes formatos: '(DD)99999-9999' ou '(DD)999999999'.";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
