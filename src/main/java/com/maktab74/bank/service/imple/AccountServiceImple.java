package com.maktab74.bank.service.imple;


import com.maktab74.bank.base.service.imple.BaseServiceImple;
import com.maktab74.bank.domain.Account;
import com.maktab74.bank.repository.AccountRepository;
import com.maktab74.bank.service.AccountService;

public class AccountServiceImple extends BaseServiceImple<Account, Long, AccountRepository>
        implements AccountService {


    public AccountServiceImple(AccountRepository repository) {
        super(repository);
    }

    @Override
    public Long findInCodeNumber(Long aLong) {

        return repository.findCodeNumber(aLong);
    }
}



