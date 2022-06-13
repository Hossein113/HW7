package com.maktab74.bank.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {

    private static final EntityManagerFactory emf;

    static {
        emf = Persistence.createEntityManagerFactory("default");
    }

    public static EntityManagerFactory getEntitymanagerfactory() {
        return emf;
    }
}
