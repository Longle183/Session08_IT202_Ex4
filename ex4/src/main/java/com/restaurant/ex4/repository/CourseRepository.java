package com.restaurant.ex4.repository;

import com.restaurant.ex4.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository
        extends JpaRepository<Course, Long> {
}