package com.restaurant.ex4.controller;

import com.restaurant.ex4.service.LessonService;
import jakarta.validation.constraints.Min;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/lessons")
@Validated
public class LessonController {

    private final LessonService service;

    public LessonController(
            LessonService service
    ) {
        this.service = service;
    }

    @GetMapping("/watch")
    public ResponseEntity<?> watchLesson(

            @RequestHeader("X-User")
            String user,

            @RequestParam
            @Min(value = 1,
                    message = "lessonId phải lớn hơn 0")
            Long lessonId
    ) {

        return ResponseEntity.ok(
                service.watchLesson(lessonId, user)
        );
    }
}