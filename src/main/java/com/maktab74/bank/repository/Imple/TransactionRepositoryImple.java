package com.maktab74.bank.repository.Imple;

import com.maktab74.bank.base.reposity.imple.BaseReposityImple;
import com.maktab74.bank.domain.Cart;
import com.maktab74.bank.domain.Transaction;
import com.maktab74.bank.repository.TransactionRepository;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;
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
    public Long findCodeTansaction(Long id) {

        return entityManager.createQuery(
                "select count(t.id) from Transaction t where t.codeTransaction =: numberCode",
                Long.class).setParameter("numberCode", id).getSingleResult();
    }


    @Override
    public List<Transaction> listTransaction(Long id) {
        return entityManager.createQuery("select t from Transaction t where t.spource.id= :id1"
                        , Transaction.class)
                .setParameter("id1", id)
                .getResultList();
    }

    @Override
    public List<Transaction> searchTransaction(Cart cart, LocalDateTime date) {
        return entityManager.createQuery("select t from Transaction t where t.transactionDate> :dateName and" +
                        " (t.destination.id=:destination or t.spource.id=:spource)", Transaction.class)
                .setParameter("destination", cart.getId())
                .setParameter("spource", cart.getId()).setParameter("dateName", date).getResultList();
    }
}
