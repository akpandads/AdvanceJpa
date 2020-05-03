package com.akpanda.advjpa.repository;

import com.akpanda.advjpa.AdvjpaApplication;
import com.akpanda.advjpa.entity.Course;
import com.akpanda.advjpa.entity.Review;
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

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AdvjpaApplication.class)
class CourseRepositoryTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    CourseReporsitory courseReporsitory;

    @Autowired
    EntityManager entityManager;

    @Test
    void findByIdTest() {
        Course course = courseReporsitory.findById(10001);
        logger.info("course found :"+course);
        Assert.assertEquals("ms in 10 days",course.getName());
    }

    @Test
    @DirtiesContext
    void deleteByIdTest() {
        courseReporsitory.deleteById(10004);
        Course course = courseReporsitory.findById(10004);
        Assert.assertNull(course);
    }

    @Test
    @DirtiesContext
    void saveCourseTest(){
        Course course = courseReporsitory.findById(1);
        Assert.assertEquals("docker",course.getName());
        course.setName("gprc details");
        courseReporsitory.save(course);
        Assert.assertEquals("gprc details", courseReporsitory.findById(1).getName());
    }

    @Test
    @DirtiesContext
    void playWithEMTest(){
        courseReporsitory.playWithEntityManager();
    }

    @Test
    public void testReviewCourseRetrieve(){
        Course course=courseReporsitory.findById(10003L);
        logger.info("Reviews -> ", course.getReviews());
    }

    @Test
    public void testgetCOurseReviewForTest(){
        Review review = entityManager.find(Review.class,600001L);
        logger.info("Course associated ->"+review.getCourse());
    }
}
