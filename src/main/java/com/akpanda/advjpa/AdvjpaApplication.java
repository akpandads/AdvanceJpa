package com.akpanda.advjpa;

import com.akpanda.advjpa.entity.Course;
import com.akpanda.advjpa.entity.Review;
import com.akpanda.advjpa.repository.CourseReporsitory;
import com.akpanda.advjpa.repository.StudentReporsitory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class AdvjpaApplication implements CommandLineRunner {

    @Autowired
    private CourseReporsitory courseReporsitory;

    @Autowired
    private StudentReporsitory studentReporsitory;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public static void main(String[] args) {
        SpringApplication.run(AdvjpaApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        Course course = courseReporsitory.findById(10001);
        //courseReporsitory.deleteById(10001);
        courseReporsitory.save(new Course("docker"));
        courseReporsitory.playWithEntityManager();

        studentReporsitory.saveStudentWothPassport();

        List<Review> reviewList = new ArrayList<>();
        Review review = new Review("4","good try");
        Review review2 = new Review("3","beginner");
        reviewList.add(review);
        reviewList.add(review2);
        courseReporsitory.addReviewsForCourse(10003L,reviewList);
    }
}
