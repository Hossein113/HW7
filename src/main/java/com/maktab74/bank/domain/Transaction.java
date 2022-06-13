package com.maktab74.bank.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Transaction {

    @Id
    @GeneratedValue
    private Long id;

    private String titile;

    private Long trasactionCodeNumder;

    @OneToOne
    private Cart cart;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitile() {
        return titile;
    }

    public void setTitile(String titile) {
        this.titile = titile;
    }

    public Long getTrasactionCodeNumder() {
        return trasactionCodeNumder;
    }

    public void setTrasactionCodeNumder(Long trasactionCodeNumder) {
        this.trasactionCodeNumder = trasactionCodeNumder;
    }

}
