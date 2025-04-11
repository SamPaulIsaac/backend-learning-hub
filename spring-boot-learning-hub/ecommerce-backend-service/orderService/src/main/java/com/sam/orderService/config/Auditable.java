package com.sam.orderService.config;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@MappedSuperclass
@Data

@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditableEntityListener.class)
public class Auditable {

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "created_by", nullable = false, updatable = false)
    private String createdBy;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    //@LastModifiedBy
    @Column(name = "updated_by", nullable = false)
    private String updatedBy;
}
