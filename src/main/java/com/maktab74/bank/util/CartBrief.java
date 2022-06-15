package com.maktab74.bank.util;

public class CartBrief {

    private String numberCart;

    private Long ccv2;

    private Long password;

    public CartBrief(String numberCart, Long ccv2, Long password) {
        this.numberCart = numberCart;
        this.ccv2 = ccv2;
        this.password = password;
    }

    public String getNumberCart() {
        return numberCart;
    }

    public void setNumberCart(String numberCart) {
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
}
