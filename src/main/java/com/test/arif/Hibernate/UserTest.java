package com.test.arif.Hibernate;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;

/**
 * Created by arifacar on 1/14/16.
 */
public class UserTest {
    private static SessionFactory sessionFactory;

    public static void main(String[] args) {

        try {

            Configuration configuration = new Configuration();
            configuration.configure();
            sessionFactory = configuration.buildSessionFactory();

        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }


        UserTest me = new UserTest();
        me.getAllUsers();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("INSERT : 1 - UPDATE: 2 - DELETE: 3");
        String processNumber = null;

        try {
            processNumber = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        switch (processNumber) {
            case "1": {
                me.insertUser(new User(105, "arifacar", "arif", "acar", "3571035710"));
                break;
            }
            case "2": {
                me.updateUser(new User(2, "asd", "asd", "asd", "123"));
                break;
            }
            case "3": {
                me.deleteUser(new User(2, "", "", "", ""));

            }
        }

        me.getAllUsers();


    }

    public void getAllUsers() {
        Session session = sessionFactory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();

            List users = session.createQuery("from User").list();
            Iterator itr = users.iterator();
            while (itr.hasNext()) {
                Object element = itr.next();
                System.out.println(element + " ");
            }

            tx.commit();
        } catch (HibernateException ex) {
            if (tx != null) tx.rollback();
            ex.printStackTrace();
        } finally {
            session.close();
        }

    }


    public Integer insertUser(User user) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        Integer lastId = null;

        try {
            tx = session.beginTransaction();

            lastId = (Integer) session.save(user);

            tx.commit();
        } catch (HibernateException ex) {
            if (tx != null) tx.rollback();
            ex.printStackTrace();

        } finally {
            session.close();
        }

        return lastId;

    }

    public void updateUser(User user) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();

            session.update(user);

            tx.commit();
        } catch (HibernateException ex) {
            if (tx != null) tx.rollback();
            ex.printStackTrace();
        } finally {
            session.close();
        }


    }

    public void deleteUser(User user) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();

            session.delete(user);

            tx.commit();
        } catch (HibernateException ex) {
            if (tx != null) tx.rollback();
            ex.printStackTrace();
        } finally {
            session.close();
        }


    }


}
