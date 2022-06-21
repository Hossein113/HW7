package com.maktab74.bank.domain;

import com.maktab74.bank.base.domain.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Account extends BaseEntity<Long> {


    private String title;

    @ManyToOne
    private Customer customer;

    @Column(unique = true)
    private Long acountCodeNumber;


    private Long validMoney;

    public Account() {

    }

    public Account(String title, Customer customer, Long acountCodeNumber, Long validMoney) {
        this.title = title;
        this.customer = customer;
        this.acountCodeNumber = acountCodeNumber;
        this.validMoney = validMoney;
    }


    public Account(Long aLong, String title, Customer customer, Long acountCodeNumber, Long validMoney) {
        super(aLong);
        this.title = title;
        this.customer = customer;
        this.acountCodeNumber = acountCodeNumber;
        this.validMoney = validMoney;
    }

    public Customer getCustomer() {
        return customer;
    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getAcountCodeNumber() {
        return acountCodeNumber;
    }

    public void setAcountCodeNumber(Long acountCodeNumber) {
        this.acountCodeNumber = acountCodeNumber;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }


    public Long getValidMoney() {
        return validMoney;
    }

    public void setValidMoney(Long validMoney) {
        this.validMoney = validMoney;
    }

    @Override
    public String toString() {
        return "Account{" +
                " " + super.toString() +
                "title='" + title + '\'' +
                ", customer=" + customer +
                ", acountCodeNumber=" + acountCodeNumber +
                ", validMoney=" + validMoney;

    }
}
