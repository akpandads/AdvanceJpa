package com.akpanda.advjpa.repository;

import com.akpanda.advjpa.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseSpringDataRepository extends JpaRepository<Course,Long> {
}
