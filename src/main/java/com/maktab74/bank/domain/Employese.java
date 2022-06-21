package com.maktab74.bank.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Employese extends User {


    @Column(unique = true)
    private Long employeseCodeNumber;

    @ManyToOne
    private Boss boss;


    public Long getEmployeseCodeNumber() {
        return employeseCodeNumber;
    }

    public void setEmployeseCodeNumber(Long employeseCodeNumber) {
        this.employeseCodeNumber = employeseCodeNumber;
    }

    @Override
    public String toString() {
        return "Employese{" +
                "employeseCodeNumber=" + employeseCodeNumber +
                ", boss=" + boss +
                "} " + super.toString();
    }
}
