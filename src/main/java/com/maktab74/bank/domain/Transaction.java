package com.maktab74.bank.domain;

import com.maktab74.bank.base.domain.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.util.Date;

@Entity
public class Transaction extends BaseEntity<Long> {


    private String titile;

    private Long valueMoney;
    @OneToOne
    private Cart spource;

    @OneToOne
    private Cart destination;

    @Column(unique = true)
    private Long codeTransaction;


    private Date today;

    public Transaction(String titile, Long valueMoney, Cart spource, Cart destination, Long codeTransaction, Date today) {
        this.titile = titile;
        this.valueMoney = valueMoney;
        this.spource = spource;
        this.destination = destination;
        this.codeTransaction = codeTransaction;
        this.today = today;
    }

    public Transaction() {

    }


    public Long getCodeTransaction() {
        return codeTransaction;
    }

    public void setCodeTransaction(Long codeTransaction) {
        this.codeTransaction = codeTransaction;
    }

    public Date getToday() {
        return today;
    }

    public void setToday(Date today) {
        this.today = today;
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


    public String getTitile() {
        return titile;
    }

    public void setTitile(String titile) {
        this.titile = titile;
    }

    public Long getValueMoney() {
        return valueMoney;
    }

    public void setValueMoney(Long trasactionCodeNumder) {
        this.valueMoney = trasactionCodeNumder;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "titile='" + titile + '\'' +
                ", valueMoney=" + valueMoney +
                ", spource=" + spource +
                ", destination=" + destination +
                ", codeTransaction=" + codeTransaction +
                ", today=" + today +
                "} " + super.toString();
    }
}

