package com.maktab74.bank.domain;

import com.maktab74.bank.base.domain.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity

public class Cart extends BaseEntity<Long> {

    @Column(unique = true)
    private Long numberCart;

    private Long ccv2;

    private Long password;

    @OneToOne
    private Account account;

    public Cart(Long numberCart, Long ccv2, Long password, Account account) {
        this.numberCart = numberCart;
        this.ccv2 = ccv2;
        this.password = password;
        this.account = account;
    }

    public Cart(Long aLong, Long numberCart, Long ccv2, Long password, Account account) {
        super(aLong);
        this.numberCart = numberCart;
        this.ccv2 = ccv2;
        this.password = password;
        this.account = account;
    }


    public Cart() {

    }



    public Long getNumberCart() {
        return numberCart;
    }

    public void setNumberCart(Long numberCart) {
        this.numberCart = numberCart;
    }

    public Long getCcv2() {
        return ccv2;
    }

    public void setCcv2(Long ccv2) {
        this.ccv2 = ccv2;
    }

    public Long getPassword() {
        return password;
    }

    public void setPassword(Long password) {
        this.password = password;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "numberCart=" + numberCart +
                ", ccv2=" + ccv2 +
                ", password=" + password +
                ", account=" + account +
                "} " + super.toString();

    }
}
