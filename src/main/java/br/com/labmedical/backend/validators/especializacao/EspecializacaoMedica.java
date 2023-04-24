package br.com.labmedical.backend.validators.especializacao;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ FIELD })
@Retention(RUNTIME)
@Constraint(validatedBy = EspecializacaoMedicaValidator.class)
@Documented
public @interface EspecializacaoMedica {
    String message() default "Especialização médica deve ser: Clínico Geral (com acento) , " +
            "Anestesista, " +
            "Dermatologista, " +
            "Ginecologista, " +
            "Neurologista, " +
            "Pediatra, " +
            "Psiquiatra ou " +
            "Ortopedista";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
