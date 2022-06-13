package com.maktab74.bank.domain;

import javax.persistence.*;

@Entity
public class Account {

    @Id
    @GeneratedValue
    private Long id;

    private String title;

    @ManyToOne
    private Customer customer;

    @OneToOne
    private Cart cart;
    @Column(unique = true)
    private Long AcountCodeNumber;

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

    public Long getAcountCodeNumber() {
        return AcountCodeNumber;
    }

    public void setAcountCodeNumber(Long acountCodeNumber) {
        AcountCodeNumber = acountCodeNumber;
    }
}
