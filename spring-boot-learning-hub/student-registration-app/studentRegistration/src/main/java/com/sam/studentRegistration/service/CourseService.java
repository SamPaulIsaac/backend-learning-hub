package com.sam.studentRegistration.service;

import com.sam.studentRegistration.entity.Course;
import com.sam.studentRegistration.repository.CourseRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class CourseService {

    private final CourseRepository courseRepository;

    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }
}
