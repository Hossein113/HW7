package com.maktab74.bank.base.reposity;

import com.maktab74.bank.base.domain.BaseEntity;

import javax.persistence.EntityTransaction;
import java.io.Serializable;
import java.util.List;

public interface BaseRepository<E extends BaseEntity<ID>, ID extends Serializable> {

    E save(E e);

    E findById(ID id);

    List<E> findAll();

    void deletById(ID id);

    Long countAll();

    void beginTransaction();

    void commitTransaction();

    void rollbackTransaction();

    EntityTransaction getTransaction();


}
