package com.maktab74.bank.util;

import java.time.LocalDateTime;

public class CartBrief {

    private Long numberCart;

    private Long ccv2;

    private Long password;

    private LocalDateTime expiration;

    public CartBrief(Long numberCart, Long ccv2, Long password, LocalDateTime expiration) {
        this.numberCart = numberCart;
        this.ccv2 = ccv2;
        this.expiration = expiration;
        this.password = password;
    }

    public CartBrief(Long numberCart, Long ccv2, Long password) {
        this.numberCart = numberCart;
        this.ccv2 = ccv2;
        this.password = password;
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

    public LocalDateTime getExpiration() {
        return expiration;
    }

    public void setExpiration(LocalDateTime expiration) {
        this.expiration = expiration;
    }

    @Override
    public String toString() {
        return "CartBrief{" +
                "numberCart='" + numberCart + '\'' +
                ", ccv2=" + ccv2 +
                ", password=" + password +
                ", getExpiration=" + expiration +
                '}';
    }
}
