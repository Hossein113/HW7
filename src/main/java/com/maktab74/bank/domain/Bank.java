package com.maktab74.bank.domain;


import com.maktab74.bank.base.domain.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Bank extends BaseEntity<Long> {


    private String title;
    @Column(unique = true)
    private Long BankCodeNumber;


    public Bank() {
    }

    public Bank(Long aLong, String title, Long bankCodeNumber) {
        super(aLong);
        this.title = title;
        BankCodeNumber = bankCodeNumber;
    }

    public Bank(String title, Long bankCodeNumber) {
        this.title = title;
        BankCodeNumber = bankCodeNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getBankCodeNumber() {
        return BankCodeNumber;
    }

    public void setBankCodeNumber(Long bankCodeNumber) {
        BankCodeNumber = bankCodeNumber;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "title='" + title + '\'' +
                ", BankCodeNumber=" + BankCodeNumber +
                '}';
    }


}
