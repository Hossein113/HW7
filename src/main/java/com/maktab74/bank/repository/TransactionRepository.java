package com.maktab74.bank.repository;

import com.maktab74.bank.base.reposity.BaseRepository;
import com.maktab74.bank.domain.Cart;
import com.maktab74.bank.domain.Transaction;

import java.time.LocalDateTime;
import java.util.List;

public interface TransactionRepository extends BaseRepository<Transaction, Long> {


    Long findCodeTansaction(Long id);

    List<Transaction> listTransaction(Long id);

    List<Transaction> searchTransaction(Cart cart, LocalDateTime dateTime);
}
