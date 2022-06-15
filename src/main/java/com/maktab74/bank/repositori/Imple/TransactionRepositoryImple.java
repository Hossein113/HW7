package com.maktab74.bank.repositori.Imple;

import com.maktab74.bank.base.reposity.imple.BaseReposityImple;
import com.maktab74.bank.domain.Transaction;
import com.maktab74.bank.repositori.TransactionRepository;

import javax.persistence.EntityManager;
import java.util.List;

public class TransactionRepositoryImple extends BaseReposityImple<Transaction, Long>
        implements TransactionRepository {
    public TransactionRepositoryImple(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Transaction> getEntityClass() {
        return Transaction.class;
    }

    @Override
    public List<Transaction> listTransaction(Long id) {
        return entityManager.createQuery("select t from Transaction t where t.spource.id=:id1"
                        , Transaction.class)
                .setParameter("id1", id)
                .getResultList();
    }
}
