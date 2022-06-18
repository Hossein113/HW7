package com.maktab74.bank.repositori.Imple;

import com.maktab74.bank.base.reposity.imple.BaseReposityImple;
import com.maktab74.bank.domain.Account;
import com.maktab74.bank.domain.Cart;
import com.maktab74.bank.repositori.CartRepository;
import com.maktab74.bank.util.CartBrief;

import javax.persistence.EntityManager;
import java.util.List;


public class CartRepositoryImple extends BaseReposityImple<Cart, Long>
        implements CartRepository {


    public CartRepositoryImple(EntityManager entityManager) {
        super(entityManager);
    }


    @Override
    public Class<Cart> getEntityClass() {
        return Cart.class;
    }


    public Cart findByAccuntId(Long acountId) {
        return entityManager.createQuery("select c from Cart c where Account.id=:example",
                Cart.class).setParameter("example", acountId).getSingleResult();
    }

    @Override
    public Cart findByAccuntId(Account account) {
        return entityManager.createQuery("select c from Cart c where c.account=: name",
                Cart.class).setParameter("name", account).getSingleResult();
    }

    @Override
    public Cart chekCart(CartBrief cartBrief) {

        return entityManager.createQuery("select c from Cart c where c.numberCart= :numberCart  " +
                        "and c.ccv2=:ccv and c.password=:pass", Cart.class)
                .setParameter("numberCart", cartBrief.getNumberCart())
                .setParameter("ccv", cartBrief.getCcv2()).setParameter("pass", cartBrief.getPassword())
                .getSingleResult()
                ;
    }

    @Override
    public Cart destination(String cart) {
        return entityManager.createQuery("select c from Cart c where c.numberCart=:numberCart"
                        , Cart.class)
                .setParameter("numberCart", cart)
                .getSingleResult();
    }

    @Override
    public void deletByAcount(Account account) {
        entityManager.createQuery("delete from Cart c where c.account=:Number ")
                .setParameter("Number", account).executeUpdate();
    }

    @Override
    public List<Cart> findAllById(Long id) {
        return entityManager.createQuery("select c from Cart c where c.account.id=:custom",
                Cart.class).setParameter("custom", id).getResultList();

    }


}


