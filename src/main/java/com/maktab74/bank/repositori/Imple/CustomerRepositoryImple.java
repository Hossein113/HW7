package com.maktab74.bank.repositori.Imple;

import com.maktab74.bank.base.reposity.imple.BaseReposityImple;
import com.maktab74.bank.domain.Customer;
import com.maktab74.bank.repositori.CustomerRepository;
import com.maktab74.bank.util.UserBrief;

import javax.persistence.EntityManager;


public class CustomerRepositoryImple extends BaseReposityImple<Customer, Long> implements CustomerRepository {

    public CustomerRepositoryImple(EntityManager entityManager) {
        super(entityManager);
    }

    @Override

    public Class<Customer> getEntityClass() {
        return Customer.class;
    }

    public Customer checkPasword(UserBrief ub) {

        return entityManager.createQuery("select c from Customer c where c.userName= :UserName " +
                        "and c.password =:Pasword", Customer.class).setParameter("UserName", ub.getUserName())
                .setParameter("Pasword", ub.getPasword()).getSingleResult();
    }
}