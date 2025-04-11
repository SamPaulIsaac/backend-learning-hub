package com.sam.userService.entity;


import com.sam.userService.config.Auditable;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "user_roles")
@Data
@EqualsAndHashCode(callSuper = true)
public class UserRole extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "role_name")
    private String name;
}
