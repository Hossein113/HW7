package com.maktab74.bank.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Boss extends User {

    @Column(unique = true)
    private Long bossCodeNumber;



    public Long getBossCodeNumber() {
        return bossCodeNumber;
    }

    public void setBossCodeNumber(Long bossCodeNumber) {
        this.bossCodeNumber = bossCodeNumber;
    }
}
