package org.erp;

import org.erp.Models.Address;
import org.erp.Models.Certificate;
import org.erp.Models.Profile;
import org.erp.Models.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();

        SessionFactory sessionFactory = configuration.configure().buildSessionFactory();

        Student student = new Student();

        // Student Details
        student.setMotherName("Mrs. Sukh Devi");
        student.setFatherName("Mr. Ram Kumar");
        student.setPhoneNumber("9315981404");
        student.setName("Suraj Kashyap");
        student.setEmail("suraj.kashyap9911@gmail.com");

        Certificate certificate = new Certificate();

        // Certificate Details
        certificate.setCourse("BCA");
        certificate.setDuration("3 Year");

        Profile profile = new Profile();

        // Profile Details
        profile.setAvatar("1.jpg");
        profile.setBio("Hello, im software engineer");
        profile.setStudent(student);

        student.setProfile(profile);
        student.setCertificate(certificate);

        ArrayList<Address> addresses = new ArrayList<>();

        Address address1 = new Address();

        address1.setCity("Noida");
        address1.setCountry("India");
        address1.setStree1("Sec 62, ARV PARK");
        address1.setStreet2("Sec 62, ARV PARK");
        address1.setStudent(student);

        Address address2 = new Address();

        address2.setCity("Ghazibad");
        address2.setCountry("India");
        address2.setStree1("Viojay, ARV PARK");
        address2.setStreet2("Viojay,, ARV PARK");
        address2.setStudent(student);
        addresses.add(address1);
        addresses.add(address2);

        student.setAddresses(addresses);

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
