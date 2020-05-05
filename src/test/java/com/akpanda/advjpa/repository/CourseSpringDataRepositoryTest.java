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
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AdvjpaApplication.class)
class CourseSpringDataRepositoryTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    CourseSpringDataRepository courseSpringDataRepository;

    @Test
    public void findById(){
        Optional<Course> course = courseSpringDataRepository.findById(10001L);
        logger.info("course is present "+ course.isPresent());
    }

    @Test
    public void playWithSpringDataRepository(){
        logger.info("All COurses :"+ courseSpringDataRepository.findAll());
        logger.info("Count All COurses :"+ courseSpringDataRepository.count());

    }

}
