package com.akpanda.advjpa.repository;

import com.akpanda.advjpa.AdvjpaApplication;
import com.akpanda.advjpa.entity.Course;
import com.akpanda.advjpa.entity.Passport;
import com.akpanda.advjpa.entity.Student;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AdvjpaApplication.class)
class StudentRepositoryTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    StudentReporsitory studentReporsitory;

    @Autowired
    EntityManager entityManager;

    @Test
    @Transactional
    public void retrievStudentWithPassport(){
        Student student = entityManager.find(Student.class,200001L);
        logger.info("Student"+student);
        logger.info("Passport"+student.getPassport());
    }

    @Test
    @Transactional
    public void retrievPassportWithStudent(){
        Passport passport = entityManager.find(Passport.class,400001L);
        logger.info("Passport"+passport);
        logger.info("Student "+passport.getStudent());
    }

    @Test
    @Transactional
    public void getStudentAndCourses(){
        Student student = entityManager.find(Student.class,200001L);
        logger.info("Student ->"+student);
        logger.info("Courses ->"+student.getCourseList());
    }
}
