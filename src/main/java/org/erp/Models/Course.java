package org.erp.Models;

import jakarta.persistence.*;
import org.hibernate.annotations.Comment;

import java.util.List;

@Entity
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "duration", nullable = false)
    @Comment(value = "Course Duration")
    private String duration;

    @Column(name = "title", nullable = false)
    @Comment(value = "Course Title")
    private String title;

    @ManyToMany(mappedBy = "courses")
    private List<Student> students;

    public Course() {
    }

    public Course(int id, String duration, String title, List<Student> students) {
        this.id = id;
        this.duration = duration;
        this.title = title;
        this.students = students;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
