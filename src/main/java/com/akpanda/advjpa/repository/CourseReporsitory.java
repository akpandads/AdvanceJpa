package com.akpanda.advjpa.repository;

import com.akpanda.advjpa.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
@Transactional
public class CourseReporsitory {

    @Autowired
    EntityManager entityManager;

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
}
