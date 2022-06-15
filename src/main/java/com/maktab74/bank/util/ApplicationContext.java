package com.maktab74.bank.util;

import com.maktab74.bank.repositori.AccountRepository;
import com.maktab74.bank.repositori.CartRepository;
import com.maktab74.bank.repositori.CustomerRepository;
import com.maktab74.bank.repositori.Imple.AccountRepositoryImple;
import com.maktab74.bank.repositori.Imple.CartRepositoryImple;
import com.maktab74.bank.repositori.Imple.CustomerRepositoryImple;
import com.maktab74.bank.repositori.Imple.TransactionRepositoryImple;
import com.maktab74.bank.repositori.TransactionRepository;

import javax.persistence.EntityManager;
import java.util.Scanner;

public class ApplicationContext {


    public static AccountRepository accountRepository;
    public static Scanner stringScanner = new Scanner(System.in);
    public static Scanner intScanner = new Scanner(System.in);
    private static SecurityUser securityUser;
    private static CustomerRepository customerRepository;

    public static EntityManager em = HibernateUtil.getEntitymanagerfactory().createEntityManager();
    private static CartRepository cartRepository;
    private static TransactionRepository transactionRepository;

    public static TransactionRepository getTransactionRepository() {
        if (transactionRepository == null) {
            transactionRepository = new TransactionRepositoryImple(em);
        }
        return transactionRepository;
    }

    public static CustomerRepository getCustomerRepository() {
        if (customerRepository == null) {
            customerRepository = new CustomerRepositoryImple(em);
        }

        return customerRepository;
    }

    public static CartRepository getCartRepository() {
        if (cartRepository == null) {
            cartRepository = new CartRepositoryImple(em);
        }
        return cartRepository;
    }

    public static AccountRepository getAccountRepository() {
        if (accountRepository == null) {
            accountRepository = new AccountRepositoryImple(em);
        }
        return accountRepository;
    }

    public static SecurityUser getSecurityUser() {
        if (securityUser == null)
            securityUser = new SecurityUser();
        return securityUser;
    }

}

