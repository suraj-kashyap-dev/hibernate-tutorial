package org.erp.Models;

import jakarta.persistence.*;
import org.hibernate.annotations.Comment;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Embedded
    private Certificate certificate;

    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
    private Profile profile;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Address> addresses;

    @ManyToMany
    @JoinTable(
            name = "student_course",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private List<Course> courses;

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public Certificate getCertificate() {
        return certificate;
    }

    public void setCertificate(Certificate certificate) {
        this.certificate = certificate;
    }

    @Column(name = "name", nullable = false, length = 100)
    @Comment(value = "Name")
    private String name;

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    @Column(name = "email", nullable = true, length = 100)
    @Comment(value = "Email")
    private String email;

    @Column(name = "father_name", nullable = true, length = 100)
    @Comment(value = "Father name")
    private String fatherName;

    @Column(name = "mother_name", nullable = true, length = 100)
    @Comment(value = "Mother Name")
    private String motherName;

    @Column(name = "phone_number", nullable = true, length = 15)
    @Comment(value = "Phone number")
    private String phoneNumber;

    @Column(name = "created_at", updatable = false)
    @Comment(value = "Created At")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    @Comment(value = "Update At")
    private LocalDateTime updatedAt;

    public Student() {}



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", fatherName='" + fatherName + '\'' +
                ", motherName='" + motherName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }

    @PrePersist
    public void prePersist() {
        LocalDateTime now = LocalDateTime.now();
        this.createdAt = now;
        this.updatedAt = now;
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}
