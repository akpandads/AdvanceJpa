package com.akpanda.advjpa.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@NamedQuery(name="get_all_courses",query="select c from Course c")
@NamedQueries({
        @NamedQuery(name="get_all_course_nqs",
                query="SELECT c FROM Course c"),
        @NamedQuery(name="get_course)name",
                query="SELECT c FROM Course c WHERE c.name = :name"),
})
@Cacheable
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

    @OneToMany(mappedBy = "course")
    private List<Review> reviews = new ArrayList<>();

    @ManyToMany(mappedBy = "courseList")
    private List<Student> students = new ArrayList<>();

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

    public List<Student> getStudents() {
        return students;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void addReview(Review review){
        this.reviews.add(review);
    }

    public void deleteReview(Review review){
        this.reviews.remove(    review);
    }
}
