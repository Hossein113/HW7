package com.maktab74.bank.domain;

import javax.persistence.*;

@Entity
@Table(name = Cart.tableName)
public class Cart {

    public static final String tableName = "cart_table";

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String number;

    private Long ccv2;

    private Long password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
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

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", ccv2=" + ccv2 +
                ", password=" + password +
                '}';
    }
}
