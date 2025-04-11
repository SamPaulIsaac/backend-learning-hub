package com.sam.orderService.entity;


import com.sam.orderService.config.Auditable;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Order extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long customerId;
    private Long productId;
    private Long itemId;
    private int quantity;
    private LocalDateTime orderDate;
    private BigDecimal totalAmount;
    private OrderStatus status;


}

