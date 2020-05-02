package com.akpanda.advjpa.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NamedQuery(name="get_all_courses",query="select c from Course c")
@NamedQueries({
        @NamedQuery(name="get_all_course_nqs",
                query="SELECT c FROM Course c"),
        @NamedQuery(name="get_course)name",
                query="SELECT c FROM Course c WHERE c.name = :name"),
})
public class Course {

    @Id
    @GeneratedValue
    private Long id;

    @Column( nullable = false)
    private String name;

    @UpdateTimestamp
    private LocalDateTime lastUpdated;

    @CreationTimestamp
    private LocalDateTime createdDate;

    public Course() {
    }

    public Course(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
