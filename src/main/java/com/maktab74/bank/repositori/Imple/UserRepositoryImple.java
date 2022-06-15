package com.maktab74.bank.repositori.Imple;

import com.maktab74.bank.base.reposity.imple.BaseReposityImple;
import com.maktab74.bank.domain.User;
import com.maktab74.bank.repositori.UserRepository;

import javax.persistence.EntityManager;

public abstract class UserRepositoryImple extends BaseReposityImple<User, Long>
        implements UserRepository {
    public UserRepositoryImple(EntityManager entityManager) {
        super(entityManager);
    }


}