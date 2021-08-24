package br.com.orange.carteira.validadores.customizado;

import org.hibernate.validator.internal.constraintvalidators.hv.br.CNPJValidator;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CPFValidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CPF_CNPJValidator implements ConstraintValidator<CPF_CNPJ, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        CPFValidator cpfValidator = new CPFValidator();
        cpfValidator.initialize(null);

        CNPJValidator cnpjValidator = new CNPJValidator();
        cnpjValidator.initialize(null);

        return cpfValidator.isValid(value, context) || cnpjValidator.isValid(value, context);
    }
}