package com.sam.productService.config;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

import static com.sam.productService.utils.GlobalUtility.getCurrentLocalDateTime;
import static com.sam.productService.utils.GlobalUtility.getUser;


public class AuditableEntityListener {

    @PrePersist
    public void prePersist(Auditable auditable) {
        auditable.setCreatedBy(getUser());
        auditable.setUpdatedBy(getUser());
        auditable.setCreatedAt(getCurrentLocalDateTime());
        auditable.setUpdatedAt(getCurrentLocalDateTime());
    }

    @PreUpdate
    public void preUpdate(Auditable auditable) {
        auditable.setUpdatedBy(getUser());
        auditable.setUpdatedAt(getCurrentLocalDateTime());

    }
}

