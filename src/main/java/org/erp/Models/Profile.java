package org.erp.Models;

import jakarta.persistence.*;
import org.hibernate.annotations.Comment;

@Entity
@Table(name = "profiles")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "bio", nullable = true)
    @Comment(value = "Bio")
    private String bio;

    @Column(name = "avatar", nullable = true)
    @Comment(value = "Avatar")
    private String avatar;

    @OneToOne
    @JoinColumn(name = "student_id")
    private Student student;

    public Profile() {
        super();
    }

    public Profile(int id, String bio, String avatar, Student student) {
        super();
        this.id = id;
        this.bio = bio;
        this.avatar = avatar;
        this.student = student;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
