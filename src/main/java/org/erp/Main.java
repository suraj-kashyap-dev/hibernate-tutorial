package org.erp;

import org.erp.Models.*;
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

        ArrayList<Course> courses = new ArrayList<>();

        Course course1 = new Course();
        course1.setDuration("3 Year");
        course1.setTitle("BCA");

        Course course2 = new Course();
        course2.setDuration("4 Year");
        course2.setTitle("BTECH");

        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();

            session.persist(course1);
            session.persist(course2);

            ArrayList<Student> students = new ArrayList<>();
            students.add(student);

            course1.setStudents(students);
            course2.setStudents(students);

            courses.add(course1);
            courses.add(course2);

            student.setCourses(courses);

            student.setAddresses(addresses);

            session.persist(student);

            tx.commit();
        }

        sessionFactory.close();

        System.out.println("Student entity persisted successfully.");
    }
}
