package com.maktab74.bank.domain;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "branch_table")
public class Branch {

    @Id
    @GeneratedValue
    private Long id;
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

    public Branch(Long id, Long branchCodeNumber, Bank bank) {
        this.id = id;
        this.branchCodeNumber = branchCodeNumber;
        this.bank = bank;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
                "id=" + id +
                ", branchCodeNumber=" + branchCodeNumber +
                ", bank=" + bank +
                '}';
    }
}
