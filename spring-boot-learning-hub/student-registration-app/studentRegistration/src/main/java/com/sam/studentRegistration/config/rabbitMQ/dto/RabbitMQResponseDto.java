package com.sam.studentRegistration.config.rabbitMQ.dto;


import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class RabbitMQResponseDto {
    private Long studentId;
    private String correlationId;
    private boolean emailStatus;
}

