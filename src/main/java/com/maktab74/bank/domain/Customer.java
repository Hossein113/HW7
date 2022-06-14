package com.maktab74.bank.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Customer extends User {


    @Column(unique = true)
    private Long customerCodeNumber;


    public Customer() {

    }

    public Customer(String firstName, String lastName, String userName, String gender,
                    Long age, String phoneNumber, String password, Long customerCodeNumber) {
        super(firstName, lastName, userName, gender, age, phoneNumber, password);
        this.customerCodeNumber = customerCodeNumber;
    }

    public Long getCustomerCodeNumber() {
        return customerCodeNumber;
    }

    public void setCustomerCodeNumber(Long customerCodeNumber) {
        this.customerCodeNumber = customerCodeNumber;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerCodeNumber=" + customerCodeNumber +
                "} " + super.toString();
    }
}
