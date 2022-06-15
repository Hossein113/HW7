package com.maktab74.bank.repositori;

import com.maktab74.bank.base.reposity.BaseRepository;
import com.maktab74.bank.domain.Customer;
import com.maktab74.bank.util.UserBrief;

public interface CustomerRepository extends BaseRepository<Customer, Long> {

    Customer checkPasword(UserBrief ub);


}