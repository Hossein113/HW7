package com.maktab74.bank.util;

import com.maktab74.bank.repository.AccountRepository;
import com.maktab74.bank.repository.CartRepository;
import com.maktab74.bank.repository.CustomerRepository;
import com.maktab74.bank.repository.Imple.AccountRepositoryImple;
import com.maktab74.bank.repository.Imple.CartRepositoryImple;
import com.maktab74.bank.repository.Imple.CustomerRepositoryImple;
import com.maktab74.bank.repository.Imple.TransactionRepositoryImple;
import com.maktab74.bank.repository.TransactionRepository;
import com.maktab74.bank.service.AccountService;
import com.maktab74.bank.service.imple.AccountServiceImple;

import javax.persistence.EntityManager;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class ApplicationContext {

    public static AccountRepository accountRepository;
    public static Scanner stringScanner = new Scanner(System.in);
    public static Scanner intScanner = new Scanner(System.in);
    private static SecurityUser securityUser;
    private static CustomerRepository customerRepository;
    private static AccountService accountService;


    public static EntityManager em = HibernateUtil.getEntitymanagerfactory().createEntityManager();
    private static CartRepository cartRepository;
    private static TransactionRepository transactionRepository;

    public static Random random = new Random();
    public static Date date = new Date();

    public static int getDate() {
        int date1 = date.getDate();
        return date1;
    }


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

    public static AccountService getAccountService() {
        if (accountService == null) {
            accountService = new AccountServiceImple(getAccountRepository());
            // accountService = new AccountServiceImple(accountRepository);
        }
        return accountService;
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

