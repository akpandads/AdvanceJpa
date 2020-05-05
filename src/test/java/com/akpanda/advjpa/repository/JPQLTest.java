package com.akpanda.advjpa.repository;

import com.akpanda.advjpa.AdvjpaApplication;
import com.akpanda.advjpa.entity.Course;
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
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Queue;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AdvjpaApplication.class)
class JPQLTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager entityManager;

    @Test
    void findById_baseic() {
        Query query = entityManager.createQuery("select c from Course c");
        List course = query.getResultList();
        logger.info("course found :"+course);
    }

    @Test
    void findById_types() {
        TypedQuery<Course> typedQuery = entityManager.createQuery("select c from Course c",Course.class);
        List<Course> course = typedQuery.getResultList();
        logger.info("course found :"+course);
    }

    @Test
    void findById_where() {
        TypedQuery<Course> typedQuery = entityManager.createQuery("select c from Course c where name like ms%",Course.class);
        List<Course> course = typedQuery.getResultList();
        logger.info("course found :"+course);
    }

    @Test
    void findById_namedQuery() {
        TypedQuery<Course> typedQuery = entityManager.createNamedQuery("get_all_courses",Course.class);
        List<Course> course = typedQuery.getResultList();
        logger.info("course found :"+course);
    }

    @Test
    void findById_namedQueries() {
        TypedQuery<Course> typedQuery = entityManager.createNamedQuery("get_all_course_nqs",Course.class);
        List<Course> course = typedQuery.getResultList();
        logger.info("course found :"+course);
    }

    @Test
    void jpql_courses_without_students(){
        Query query = entityManager.createQuery("select c from Course c where c.students is empty",Course.class);
        List<Course> course = query.getResultList();
        logger.info("course found  with no student :"+course);
    }

    @Test
    void jpql_courses_with_students(){
        Query query = entityManager.createQuery("select c from Course c where size(c.students) >= 2",Course.class);
        List<Course> course = query.getResultList();
        logger.info("course found :"+course);
    }

    @Test
    void jpql_courses_with_students_orderby(){
        Query query = entityManager.createQuery("select c from Course c order by size(c.students)",Course.class);
        List<Course> course = query.getResultList();
        logger.info("course found :"+course);
    }

    @Test
    void jpql_courses_with_students_like(){
        Query query = entityManager.createQuery("select s from Student s where s.passport.number like '%L%'", Student.class);
        List<Course> course = query.getResultList();
        logger.info("Student Passport :"+course);
    }

    @Test
    void jpql_left_join(){
        Query query = entityManager.createQuery("select c,s from Course c LEFT join c.students s ");
        List<Object[]> resultList = query.getResultList();
        logger.info("Result Size :"+resultList.size());
        for(Object[] result: resultList){
            logger.info("Course :"+result[0]+" Student : "+result[1]);
        }
    }

    @Test
    void jpql_normal_join(){
        Query query = entityManager.createQuery("select c,s from Course c join c.students s");
        List<Object[]> resultList = query.getResultList();
        logger.info("Join result size :"+resultList.size());
        for(Object[] result: resultList){
            logger.info("Course :"+result[0]+" Student : "+result[1]);
        }
    }

    @Test
    void jpql_cross_join(){
        Query query = entityManager.createQuery("select c,s from Course c,Student s");
        List<Object[]> resultList = query.getResultList();
        logger.info("Join result size :"+resultList.size());
        for(Object[] result: resultList){
            logger.info("Course :"+result[0]+" Student : "+result[1]);
        }
    }
}
