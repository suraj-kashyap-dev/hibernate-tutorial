package org.erp;

import org.erp.Models.Certificate;
import org.erp.Models.Profile;
import org.erp.Models.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();

        SessionFactory sessionFactory = configuration.configure().buildSessionFactory();

        Student student = new Student();

        student.setMotherName("Mrs. Sukh Devi");
        student.setFatherName("Mr. Ram Kumar");
        student.setPhoneNumber("9315981404");
        student.setName("Suraj Kashyap");
        student.setEmail("suraj.kashyap9911@gmail.com");

        Certificate certificate = new Certificate();

        certificate.setCourse("BCA");
        certificate.setDuration("3 Year");

        Profile profile = new Profile();

        profile.setAvatar("1.jpg");
        profile.setBio("Hello, im software engineer");
        profile.setStudent(student);

        student.setProfile(profile);

        student.setCertificate(certificate);

        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.persist(student);
            tx.commit();
        }

        sessionFactory.close();

//        Configuration configuration = new Configuration();
//
//        SessionFactory sessionFactory = configuration.configure().buildSessionFactory();
//
//        Session session = sessionFactory.openSession();
//
//        Address address = session.get(Address.class, 1);
//
//        System.out.println(address);
//
//        sessionFactory.close();
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
