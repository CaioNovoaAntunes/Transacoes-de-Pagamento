package br.com.orange.carteira.validadores.customizado;

import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class UniqueValueValidator implements ConstraintValidator<UniValueValid, Object> {

    @PersistenceContext
    private final EntityManager entityManager;
    private Class<?> klazz;
    private String field;

    public UniqueValueValidator(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void initialize(UniValueValid param) {
        this.klazz = param.klazz();
        this.field = param.field();
    }


    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {

        List<?> resultList = entityManager.createQuery("SELECT 1 FROM " + klazz.getSimpleName() + " WHERE " +
                field + " = :valor")
                .setParameter("valor", value).getResultList();

        Assert.state(resultList.size() <= 1, "O campo " + field + "Objeto não encontrado");

        return resultList.isEmpty();
    }

}