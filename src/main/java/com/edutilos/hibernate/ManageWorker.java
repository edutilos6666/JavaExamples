package com.edutilos.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

/**
 * Created by edutilos on 19.06.17.
 */
public class ManageWorker {
    private static SessionFactory factory;
    public static void main(String[] args) {
        factory = new Configuration().configure().buildSessionFactory();
        addWorker("foo", 10 , 100.0, true);
        addWorker("bar", 20 , 200.0, false);
        addWorker("bim", 30, 300.0, true);

        listWorkers();
        System.out.println();
        updateWorker(1L , new Worker("new_foo", 66, 666.6, false));
        listWorkers();
        System.out.println();
        removeWorker(1L);
        listWorkers();
        System.out.println();

        factory.close();
    }


    private static void addWorker(String name, int age, double wage ,boolean active) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Worker w = new Worker(name, age, wage, active);
            session.save(w);
            tx.commit();
        } catch(Exception ex) {
           tx.rollback();
            ex.printStackTrace();
        } finally {
            session.close();
        }
    }

    private static void updateWorker(long id , Worker newW) {
        Session session= factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Worker w = session.get(Worker.class, id);
            w.setName(newW.getName());
            w.setAge(newW.getAge());
            w.setWage(newW.getWage());
            w.setActive(newW.isActive());
            session.update(w);
            tx.commit();
        } catch(Exception ex) {
            tx.rollback();
            ex.printStackTrace();
        } finally {
            session.close();
        }
    }


    private static void removeWorker(long id) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Worker w = session.get(Worker.class, id);
            session.remove(w);
            tx.commit();
        } catch(Exception ex) {
            tx.rollback();
            ex.printStackTrace();
        } finally {
            session.close();
        }
    }


    private static void listWorkers() {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            List<Worker> list = session.createQuery("from Worker", Worker.class).list();
            for(Worker w: list) {
                System.out.println(w.toString());
            }
            tx.commit();
        } catch(Exception ex) {
            tx.rollback();
            ex.printStackTrace();
        } finally {
            session.close();
        }
    }
}
