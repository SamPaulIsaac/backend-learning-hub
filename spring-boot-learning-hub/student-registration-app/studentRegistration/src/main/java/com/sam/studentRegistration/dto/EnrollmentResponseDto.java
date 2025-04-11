package com.sam.studentRegistration.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EnrollmentResponseDto {
    private Long studentId;
    private Long courseId;
}
