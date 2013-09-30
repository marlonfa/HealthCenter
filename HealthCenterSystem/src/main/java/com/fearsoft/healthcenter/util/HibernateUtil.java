/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fearsoft.healthcenter.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Eder Ferreira
 */

/*
 * PADRAO ESTRUTURAL SINGLETON
 */

public class HibernateUtil {

    private static SessionFactory sessionFactory = null;

    private HibernateUtil() {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            sessionFactory = new Configuration().configure().buildSessionFactory();

        } catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }

    }

    public static SessionFactory getInstance() {
        if (sessionFactory == null) {
            new HibernateUtil();
        }
        return sessionFactory;
    }
}
