package com.akpanda.advjpa.repository;

import com.akpanda.advjpa.entity.Course;
import com.akpanda.advjpa.entity.Review;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CourseReporsitory {

    @Autowired
    EntityManager entityManager;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public Course findById(long id){
        return entityManager.find(Course.class,id);
    }

    public void save(Course course){
        if(course.getId()==null){
            entityManager.persist(course);
        }
        else{
            entityManager.merge(course);
        }

    }

    public void deleteById(long id){
        Course course = findById(id);
        entityManager.remove(course);
    }

    public void playWithEntityManager(){
        Course course1 = new Course("aws funda");
        entityManager.persist(course1);
        entityManager.flush();

        course1.setName("new aws funda");
        entityManager.flush();

        Course course2 = new Course("angularjs");
        entityManager.persist(course2);
        entityManager.flush();

        //entityManager.detach(course2);
        course2.setName("angular 8");

        entityManager.refresh(course2); // gets the data from db and synchs it up
        entityManager.flush();

        entityManager.clear(); // clears all managed entities

        course1.setName("azure to aws migration");
    }

    public void addReviewsForCourse(Long courseId, List<Review> reviews){
        Course course = findById(courseId);
        logger.info("course Reviews -> "+ course.getReviews());

        for(Review review: reviews){
            course.addReview(review);
            review.setCourse(course);
            entityManager.persist(review);
        }
    }
}
