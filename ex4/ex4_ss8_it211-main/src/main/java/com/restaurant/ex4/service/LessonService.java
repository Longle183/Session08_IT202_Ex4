package com.restaurant.ex4.service;

import com.restaurant.ex4.entity.LessonVideo;
import com.restaurant.ex4.exception.AccessDeniedException;
import com.restaurant.ex4.exception.ResourceNotFoundException;
import com.restaurant.ex4.repository.LessonVideoRepository;
import org.springframework.stereotype.Service;

@Service
public class LessonService {

    private final LessonVideoRepository repository;

    public LessonService(
            LessonVideoRepository repository
    ) {
        this.repository = repository;
    }

    public String watchLesson(
            Long lessonId,
            String user
    ) {

        LessonVideo lesson = repository.findById(lessonId)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Lesson video not found"
                        )
                );

        if (!lesson.getIsFree()) {

            if (!"premium_user".equals(user)) {

                throw new AccessDeniedException(
                        "You have not purchased this course yet."
                );
            }
        }

        return lesson.getVideoUrl();
    }
}