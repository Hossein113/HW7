package com.maktab74.bank.repositori;

import com.maktab74.bank.base.reposity.BaseRepository;
import com.maktab74.bank.domain.Cart;
import com.maktab74.bank.domain.Transaction;

import java.util.List;

public interface TransactionRepository extends BaseRepository<Transaction, Long> {


    List<Transaction> listTransaction(Long id);

    List<Transaction> searchTransaction(Cart cart);
}
