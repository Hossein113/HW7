package com.maktab74.bank.repository;

import com.maktab74.bank.base.reposity.BaseRepository;
import com.maktab74.bank.domain.Account;

import java.util.List;

public interface AccountRepository extends BaseRepository<Account, Long> {


     Account findAcountUser(Long id);


     List<Account> findAllById(Long id);

     void deletedByIdAcount(Long id);

     void inTransaction(Long id, Account account); //service

     void outTransaction(Long id, Account account);

     Long findCodeNumber(Long id);

     Long findByAccountCode(Account account);

}
