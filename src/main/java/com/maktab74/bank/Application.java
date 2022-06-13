package com.maktab74.bank;

import com.maktab74.bank.util.HibernateUtil;

public class Application {

    public static void main(String[] args) {

        System.out.println("start");


        HibernateUtil.getEntitymanagerfactory().createEntityManager();


        System.out.println("END");

    }
}
