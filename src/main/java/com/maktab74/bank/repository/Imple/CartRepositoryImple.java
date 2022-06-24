package com.maktab74.bank.repository.Imple;

import com.maktab74.bank.base.reposity.imple.BaseReposityImple;
import com.maktab74.bank.domain.Account;
import com.maktab74.bank.domain.Cart;
import com.maktab74.bank.repository.CartRepository;
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


    public Cart findByAccuntIdOrg(Long acountId) {
        return entityManager.createQuery("select c from Cart c where Account.id=:example",
                Cart.class).setParameter("example", acountId).getSingleResult();
    }

    @Override
    public Cart findByAccuntIdOrg(Account account) {
        return entityManager.createQuery("select c from Cart c where c.account=: nameAccount",
                Cart.class).setParameter("nameAccount", account).getSingleResult();
    }

    @Override
    public Long chekCart(CartBrief cartBrief) {


        Long singleResult = entityManager.createQuery("select count (c.id) from Cart c where " +
                                "c.numberCart=: idDart and " +
                                "c.password=: idPassword and" +
                                " c.ccv2=: cvv2",
                        Long.class)
                .setParameter("idDart", cartBrief.getNumberCart())
                .setParameter("idPassword", cartBrief.getPassword())
                .setParameter("cvv2", cartBrief.getCcv2()).getSingleResult();
        return
                singleResult;
    }

    @Override
    public Long findCodeNumber(Long id) {
        return entityManager.createQuery(
                "select count(c.id) from Cart c where c.numberCart =: numberCode",
                Long.class).setParameter("numberCode", id).getSingleResult();

    }

    @Override
    public Cart destination(Long cart) {
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

    @Override
    public Account findByCart(Cart cart) {
        return entityManager.createQuery("select a from Account a where a.id=:nameCart",
                Account.class).setParameter("nameCart", cart).getSingleResult();
    }

    @Override
    public Account findByCart(Long id) {
        return entityManager.createQuery("select c.account from Cart c where c.id= :nameCart",
                Account.class).setParameter("nameCart", id).getSingleResult();
    }


}



