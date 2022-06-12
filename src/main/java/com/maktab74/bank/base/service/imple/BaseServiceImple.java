package com.maktab74.bank.base.service.imple;

import com.maktab74.bank.base.domain.BaseEntity;
import com.maktab74.bank.base.reposity.BaseRepository;
import com.maktab74.bank.base.service.BaseService;

import java.io.Serializable;
import java.util.List;

public class BaseServiceImple<E extends BaseEntity<ID>, ID extends Serializable,
        R extends BaseRepository<E, ID>> implements BaseService<E, ID> {

    protected final R repository;

    public BaseServiceImple(R repository) {
        this.repository = repository;
    }

    @Override
    public E save(E e) {

        repository.beginTransaction();
        e = repository.save(e);
        repository.commitTransaction();
        return e;
    }

    @Override
    public E findById(ID id) {

        return repository.findById(id);


    }

    @Override
    public List<E> findAll() {

        return repository.findAll();

    }

    @Override
    public void deleteById(ID id) {
        repository.deletById(id);

    }

    @Override
    public long countAll() {
        return repository.countAll();
    }
}
