package org.erp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.erp.Models.Address;

public class Main {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();

        SessionFactory sessionFactory = configuration.configure().buildSessionFactory();

        Session session = sessionFactory.openSession();

        Address address = session.get(Address.class, 1);

        System.out.println(address);

        sessionFactory.close();
//        Storing the data into the database
//        System.out.println("App is starting....");
//
//        Configuration configuration = new Configuration();
//        SessionFactory sessionFactory = configuration.configure().buildSessionFactory();
//
//        Address address = new Address();
//        address.setCity("Noida");
//        address.setCountry("India");
//        address.setStree1("Sec 62, ARV PARK");
//        address.setStreet2("Sec 62, ARV PARK");
//
//        try (Session session = sessionFactory.openSession()) {
//            Transaction tx = session.beginTransaction();
//            session.persist(address);
//            tx.commit();
//        }
//
//        System.out.println(address);
    }
}
