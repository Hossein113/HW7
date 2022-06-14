package com.maktab74.bank.util;

import com.maktab74.bank.domain.Customer;

public class SecurityUser {

    Customer currentUser;

    public Customer getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(Customer currentUser) {
        this.currentUser = currentUser;
    }

    public void logOut() {
        this.currentUser = null;
    }
}
