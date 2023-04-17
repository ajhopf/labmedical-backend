package br.com.labmedical.backend.validators.genero;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ FIELD })
@Retention(RUNTIME)
@Constraint(validatedBy = GeneroValidator.class)
@Documented
public @interface Genero {
    String message() default "Gênero não cadastrado na base de dados. O gênero deve ser 'feminino', 'masculino' ou 'outro'.";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
