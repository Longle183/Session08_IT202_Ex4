package com.restaurant.ex4.repository;

import com.restaurant.ex4.entity.LessonVideo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonVideoRepository
        extends JpaRepository<LessonVideo, Long> {
}