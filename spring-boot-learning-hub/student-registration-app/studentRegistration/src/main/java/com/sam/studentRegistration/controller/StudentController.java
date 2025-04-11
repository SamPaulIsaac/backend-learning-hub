package com.sam.studentRegistration.controller;

import com.sam.studentRegistration.dto.StudentResponseDto;
import com.sam.studentRegistration.entity.Student;
import com.sam.studentRegistration.service.StudentService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@AllArgsConstructor
@Slf4j
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public ResponseEntity<List<StudentResponseDto>> getAllStudents() {
        log.info("Get all students invoked.");
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentResponseDto> getStudentById(@PathVariable Long id) {
        log.info("Get student by id invoked.");
        StudentResponseDto student = studentService.getStudentById(id);
        return ResponseEntity.ok(student);
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        log.info("Create student invoked.");
        return ResponseEntity.ok(studentService.createStudent(student));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id) {
        log.info("Delete student invoked.");
        studentService.deleteStudent(id);
        return ResponseEntity.ok("Deleted student with id: " + id);
    }
}
