package br.com.orange.carteira.validador;

import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class CheckIfExistsValidator implements ConstraintValidator<CheckIfExist, Object> {

    @PersistenceContext
    private final EntityManager entityManager;
    private Class<?> klazz;
    private String field;

    public CheckIfExistsValidator(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void initialize(CheckIfExist param) {
        this.klazz = param.klazz();
        this.field = param.field();
    }


    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {

        List<?> resultList = entityManager.createQuery("SELECT 1 FROM " + klazz.getSimpleName() + " WHERE " +
                field + " = :valor")
                .setParameter("valor", value).getResultList();

        Assert.state(resultList.size() <= 1, "O campo " + field + " tem um valor");

        return !resultList.isEmpty();
    }

}