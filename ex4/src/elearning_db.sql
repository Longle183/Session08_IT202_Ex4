CREATE DATABASE elearning_db;

USE elearning_db;

CREATE TABLE course (
                        id BIGINT PRIMARY KEY AUTO_INCREMENT,
                        title VARCHAR(255)
);

CREATE TABLE lesson_video (
                              id BIGINT PRIMARY KEY AUTO_INCREMENT,
                              course_id BIGINT,
                              video_url VARCHAR(500),
                              is_free BOOLEAN
);

INSERT INTO course(title)
VALUES
    ('Java Spring Boot'),
    ('REST API Master');

INSERT INTO lesson_video(
    course_id,
    video_url,
    is_free
)
VALUES
    (
        1,
        'https://video.com/java-intro',
        true
    ),
    (
        2,
        'https://video.com/rest-secure',
        false
    );