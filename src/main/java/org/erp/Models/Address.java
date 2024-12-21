package org.erp.Models;

import jakarta.persistence.*;
import org.hibernate.annotations.Comment;

import java.time.LocalDateTime;

@Entity
@Table(name = "addresses")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "city")
    @Comment(value = "City")
    private String city;

    @Column(name = "country")
    @Comment(value = "Country")
    private String country;

    @Column(name = "street_1")
    @Comment(value = "Street 1")
    private String stree1;

    @Column(name = "street_2")
    @Comment(value = "Street 2")
    private String street2;

    @Column(name = "created_at", updatable = false)
    @Comment(value = "Created At")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    @Comment(value = "Update At")
    private LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Address() {
        super();
    }

    public Address(int id, String city, String country, String stree1, String street2, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.city = city;
        this.country = country;
        this.stree1 = stree1;
        this.street2 = street2;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStree1() {
        return stree1;
    }

    public void setStree1(String stree1) {
        this.stree1 = stree1;
    }

    public String getStreet2() {
        return street2;
    }

    public void setStreet2(String street2) {
        this.street2 = street2;
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
        return "Address{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", stree1='" + stree1 + '\'' +
                ", street2='" + street2 + '\'' +
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
