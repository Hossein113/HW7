package com.maktab74.bank.service;

import com.maktab74.bank.base.service.BaseService;
import com.maktab74.bank.domain.Account;

public interface AccountService extends BaseService<Account, Long> {

    Long findInCodeNumber(Long id);


}
