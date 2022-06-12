package com.maktab74.bank.util;

import javax.persistence.EntityManager;

public class ApplicationContext {

    public static EntityManager em = HibernateUtil.getEntitymanagerfactory().createEntityManager();


}
