package com.maktab74.bank.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Customer extends User {


    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private Long Customer;


    public Customer() {
    }


    public Customer(Long id, Long customer) {
        this.id = id;
        Customer = customer;
    }

    public Customer(Long id, String firstName, String lastName, String userName, String gender,
                    Long age, String phoneNumber, String password, Long id1, Long customer) {
        super(id, firstName, lastName, userName, gender, age, phoneNumber, password);
        this.id = id1;
        Customer = customer;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomer() {
        return Customer;
    }

    public void setCustomer(Long customer) {
        Customer = customer;
    }
}
