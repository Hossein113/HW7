package com.maktab74.bank.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Bank {

    @Id
    @GeneratedValue
    private Long id;

    private String title;
    @Column(unique = true)
    private Long BankCodeNumber;

    public Bank() {
    }

    public Bank(Long id, String title, Long bankCodeNumber) {
        this.id = id;
        this.title = title;
        BankCodeNumber = bankCodeNumber;
    }

    public Long getId() {
        return id;
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

    public Long getCodeNumber() {
        return BankCodeNumber;
    }

    public void setCodeNumber(Long codeNumber) {
        BankCodeNumber = codeNumber;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", CodeNumber=" + BankCodeNumber +
                '}';
    }
}
