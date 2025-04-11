package com.sam.studentRegistration.service;

import com.sam.studentRegistration.entity.Enrollment;
import com.sam.studentRegistration.repository.EnrollmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EnrollmentService {

    private final EnrollmentRepository enrollmentRepository;

    public Enrollment createEnrollment(Enrollment enrollment) {
        return enrollmentRepository.save(enrollment);
    }
}
