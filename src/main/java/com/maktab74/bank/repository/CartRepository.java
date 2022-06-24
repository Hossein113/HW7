package com.maktab74.bank.repository;

import com.maktab74.bank.base.reposity.BaseRepository;
import com.maktab74.bank.domain.Account;
import com.maktab74.bank.domain.Cart;
import com.maktab74.bank.util.CartBrief;

import java.util.List;

public interface CartRepository extends BaseRepository<Cart, Long> {

    Cart findByAccuntIdOrg(Long id);

    Cart findByAccuntIdOrg(Account account);

    Long chekCart(CartBrief cartBrief);

    Cart destination(Long cart);

    void deletByAcount(Account account);

    List<Cart> findAllById(Long id);


    Account findByCart(Cart cart);

    Account findByCart(Long id);

    Long findCodeNumber(Long id);

}
