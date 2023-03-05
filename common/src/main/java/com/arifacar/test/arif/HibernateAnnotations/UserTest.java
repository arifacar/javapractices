package com.arifacar.test.arif.HibernateAnnotations;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

/**
 * Created by arifacar on 1/15/16.
 */
public class UserTest {
    private static SessionFactory sessionFactory;

    public static void main(String[] args) {

        try {
            Configuration configuration = new Configuration();
            configuration.configure();
            sessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            System.err.print("Failed to create sessionFactory object. " + ex);
            throw new ExceptionInInitializerError(ex);
        }

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        User user = new User("aaaa","asd","aaa","123");

        session.save(user);

        session.getTransaction().commit();

    }

}
