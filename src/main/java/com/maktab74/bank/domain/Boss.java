package com.maktab74.bank.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Boss extends User {

    @Id
    @GeneratedValue
    private Long id;
    @Column(unique = true)
    private Long bossCodeNumber;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBossCodeNumber() {
        return bossCodeNumber;
    }

    public void setBossCodeNumber(Long bossCodeNumber) {
        this.bossCodeNumber = bossCodeNumber;
    }
}
