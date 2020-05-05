package com.akpanda.advjpa.repository;

import com.akpanda.advjpa.AdvjpaApplication;
import com.akpanda.advjpa.entity.Course;
import com.akpanda.advjpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AdvjpaApplication.class)
class CriteriaQueryTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager entityManager;

    @Test
    void find_all_course_criteria() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Course> courseCriteriaQuery= criteriaBuilder.createQuery(Course.class);
        Root<Course> courseRoot = courseCriteriaQuery.from(Course.class);
        TypedQuery<Course> typedQuery = entityManager.createQuery(courseCriteriaQuery.select(courseRoot));
        List<Course> course = typedQuery.getResultList();
        logger.info("course found :"+course);
    }

    @Test
    void find_course_like_criteria() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Course> courseCriteriaQuery= criteriaBuilder.createQuery(Course.class);
        Root<Course> courseRoot = courseCriteriaQuery.from(Course.class);

        Predicate like = criteriaBuilder.like(courseRoot.get("name"),"ms%");
        courseCriteriaQuery.where(like);

        TypedQuery<Course> typedQuery = entityManager.createQuery(courseCriteriaQuery.select(courseRoot));
        List<Course> course = typedQuery.getResultList();
        logger.info("course found :"+course);
    }

    @Test
    void find_course_without_student_criteria() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Course> courseCriteriaQuery= criteriaBuilder.createQuery(Course.class);
        Root<Course> courseRoot = courseCriteriaQuery.from(Course.class);

        Predicate like = criteriaBuilder.isEmpty(courseRoot.get("student"));
        courseCriteriaQuery.where(like);

        TypedQuery<Course> typedQuery = entityManager.createQuery(courseCriteriaQuery.select(courseRoot));
        List<Course> course = typedQuery.getResultList();
        logger.info("course found :"+course);
    }

    @Test
    void find_course_join_student_criteria() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Course> courseCriteriaQuery= criteriaBuilder.createQuery(Course.class);
        Root<Course> courseRoot = courseCriteriaQuery.from(Course.class);

        Join<Object,Object> join = courseRoot.join("student");

        TypedQuery<Course> typedQuery = entityManager.createQuery(courseCriteriaQuery.select(courseRoot));
        List<Course> course = typedQuery.getResultList();
        logger.info("course found :"+course);
    }

    @Test
    void find_course_left_join_student_criteria() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Course> courseCriteriaQuery= criteriaBuilder.createQuery(Course.class);
        Root<Course> courseRoot = courseCriteriaQuery.from(Course.class);

        Join<Object,Object> join = courseRoot.join("student",JoinType.LEFT);

        TypedQuery<Course> typedQuery = entityManager.createQuery(courseCriteriaQuery.select(courseRoot));
        List<Course> course = typedQuery.getResultList();
        logger.info("course found :"+course);
    }

}
