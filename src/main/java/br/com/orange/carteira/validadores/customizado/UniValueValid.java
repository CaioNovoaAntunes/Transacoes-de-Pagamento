package br.com.orange.carteira.validadores.customizado;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = UniqueValueValidator.class)
public @interface UniValueValid {

    String message() default "Objeto já encontrado";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String value() default "";

    String field();

    Class<?> klazz();
}