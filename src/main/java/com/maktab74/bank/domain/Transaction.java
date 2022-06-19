package com.maktab74.bank.domain;

import com.maktab74.bank.base.domain.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Transaction extends BaseEntity<Long> {

    @Id
    @GeneratedValue
    private Long id;

    private String titile;

    private Long trasactionCodeNumder;

    @OneToOne
    private Cart spource;

    @OneToOne
    private Cart destination;

    public Transaction(String titile, Long trasactionCodeNumder, Cart spource, Cart destination) {
        this.titile = titile;
        this.trasactionCodeNumder = trasactionCodeNumder;
        this.spource = spource;
        this.destination = destination;
    }

    public Transaction() {

    }


    public Cart getSpource() {
        return spource;
    }

    public void setSpource(Cart spource) {
        this.spource = spource;
    }

    public Cart getDestination() {
        return destination;
    }

    public void setDestination(Cart destination) {
        this.destination = destination;
    }

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

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", titile='" + titile + '\'' +
                ", valueMoney=" + trasactionCodeNumder +
                ", spource=" + spource.getNumberCart() +
                ", destination=" + destination.getNumberCart();
    }
}

