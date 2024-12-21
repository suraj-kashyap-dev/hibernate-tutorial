package org.erp.Models;

import jakarta.persistence.*;
import org.hibernate.annotations.Comment;

@Embeddable
public class Certificate {
    @Comment(value = "Course Name")
    private String course;

    @Comment(value = "Duration")
    private String duration;

    public String getCourse() {
        return course;
    }

    public Certificate() {
        super();
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Certificate(String course, String duration) {
        super();
        this.course = course;
        this.duration = duration;
    }
}
