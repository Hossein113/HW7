package com.maktab74.bank.repositori.Imple;

import com.maktab74.bank.base.reposity.imple.BaseReposityImple;
import com.maktab74.bank.domain.Account;
import com.maktab74.bank.repositori.AccountRepository;

import javax.persistence.EntityManager;
import java.util.List;

public class AccountRepositoryImple extends BaseReposityImple<Account, Long> implements AccountRepository {


    public AccountRepositoryImple(EntityManager entityManager) {
        super(entityManager);
    }


    @Override
    public Class<Account> getEntityClass() {
        return Account.class;
    }

    @Override
    public Account findAcountUser(Long currentId) {

        return entityManager.createQuery("select a from Account a where a.id= :customerId",
                        Account.class).setParameter("customerId", currentId)
                .getSingleResult();

    }

    @Override
    public List<Account> findAllById(Long currentId) {
        return entityManager.createQuery("select a from Account a where a.customer.id=:custom",
                Account.class).setParameter("custom", currentId).getResultList();
    }

    @Override
    public void deletedByIdAcount(Long idNumber) {
        entityManager.createQuery("delete from Account a where a.id=:idNumber")
                .setParameter("idNumber", idNumber).executeUpdate();
    }


    @Override
    public void outTransaction(Long id, Account account) {
        entityManager.createQuery(
                        "UPDATE Account a SET a.validMoney =:validMoney where id =: idName")
                .setParameter("validMoney", account.getValidMoney() + id).setParameter("idName", account.getId())
                .executeUpdate();

    }

    @Override
    public void inTransaction(Long id, Account account) {

        entityManager.createQuery(
                        " UPDATE Account a SET a.validMoney =:validMoney where id =: idName")
                .setParameter("validMoney", account.getValidMoney() - id - 500).setParameter("idName", account.getId())
                .executeUpdate();
    }


}



