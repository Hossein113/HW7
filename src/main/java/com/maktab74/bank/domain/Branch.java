package com.maktab74.bank.domain;


import com.maktab74.bank.base.domain.BaseEntity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "branch_table")
public class Branch extends BaseEntity<Long> {


    @Column(unique = true)
    private Long branchCodeNumber;

    @ManyToOne
    private Bank bank;

    @ManyToMany
    private List<Customer> customer;

    @OneToMany
    private List<Employese> employese;

    @OneToOne
    private Boss boss;

    public Branch() {

    }

    public Branch(Long branchCodeNumber, Bank bank) {

        this.branchCodeNumber = branchCodeNumber;
        this.bank = bank;
    }

    public Branch(Long aLong, Long branchCodeNumber, Bank bank, List<Customer> customer, List<Employese> employese, Boss boss) {
        super(aLong);
        this.branchCodeNumber = branchCodeNumber;
        this.bank = bank;
        this.customer = customer;
        this.employese = employese;
        this.boss = boss;
    }

    public Long getBranchCodeNumber() {
        return branchCodeNumber;
    }

    public void setBranchCodeNumber(Long branchCodeNumber) {
        this.branchCodeNumber = branchCodeNumber;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    @Override
    public String toString() {
        return "Branch{" +
                "branchCodeNumber=" + branchCodeNumber +
                ", bank=" + bank +
                ", customer=" + customer +
                ", employese=" + employese +
                ", boss=" + boss +
                "} " + super.toString();
    }
}

