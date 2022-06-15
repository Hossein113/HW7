package com.maktab74.bank.repositori;

import com.maktab74.bank.base.reposity.BaseRepository;
import com.maktab74.bank.domain.Cart;
import com.maktab74.bank.util.CartBrief;

public interface CartRepository extends BaseRepository<Cart, Long> {

    Cart findByAccuntId(Long id);


    Cart chekCart(CartBrief cartBrief);

    Cart destination(String cart);


}
