package com.maktab74.bank.base.reposity.imple;

import com.maktab74.bank.base.domain.BaseEntity;
import com.maktab74.bank.base.reposity.BaseRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.io.Serializable;
import java.util.List;

public abstract class BaseReposityImple<E extends BaseEntity<ID>, ID extends Serializable> implements BaseRepository<E, ID> {

    private EntityManager entityManager;

    private Class<E> entityClass;

    private BaseReposityImple(EntityManager entityManager) {

        this.entityManager = entityManager;
        this.entityClass = getEntityClass();
    }

    public abstract Class<E> getEntityClass();

    @Override
    public E save(E e) {

        if (e.getId() == null) {
            entityManager.persist(e);
        } else {
            e = entityManager.merge(e);
        }
        return e;
    }

    @Override
    public E findById(ID id) {

        return entityManager.find(entityClass, id);
    }

    @Override
    public List<E> findAll() {
        return entityManager.createQuery(
                "select e from " + entityClass.getSimpleName() + " e",
                entityClass).getResultList();

    }

    public void deletById(ID id) {

        entityManager.remove(entityManager.find(entityClass, id));
    }

    @Override
    public Long countAll() {

        return entityManager.createQuery(
                "select count(id) from" + entityClass.getSimpleName() + " e"
                , Long.class).getSingleResult();

    }

    @Override

    public void beginTransaction() {
        if (!entityManager.getTransaction().isActive()) {
            entityManager.getTransaction().begin();
        }
    }

    public void commitTransaction() {

        entityManager.getTransaction().commit();

    }

    public void rollbackTransaction() {

        entityManager.getTransaction().rollback();
    }

    public EntityTransaction getTransaction() {
        return entityManager.getTransaction();
    }
}
