package com.maktab74.bank.domain;

import com.maktab74.bank.base.domain.BaseEntity;

import javax.persistence.*;

@Entity
public class Account extends BaseEntity<Long> {

    @Id
    @GeneratedValue
    private Long id;

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

    public Account(Long id, String title, Customer customer, Long validMoney) {
        this.id = id;
        this.title = title;
        this.customer = customer;
        this.validMoney = validMoney;
    }

    public Long getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setId(Long id) {
        this.id = id;
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
                "id=" + id +
                ", title='" + title + '\'' +
                ", customer=" + customer +
                ", AcountCodeNumber=" + acountCodeNumber +
                ", validMoney=" + validMoney +
                "} " + super.toString();
    }
}
