package com.sam.studentRegistration.controller;

import com.sam.studentRegistration.entity.Course;
import com.sam.studentRegistration.service.CourseService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/courses")
@AllArgsConstructor
@Slf4j
public class CourseController {

    private final CourseService courseService;

    @PostMapping
    public Course createCourse(@RequestBody Course course) {
        log.info("Create course invoked.");
        return courseService.createCourse(course);
    }
}
