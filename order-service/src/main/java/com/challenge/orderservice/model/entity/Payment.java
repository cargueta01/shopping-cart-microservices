package com.challenge.orderservice.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "payments")
@Data
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String paymentMethod; // e.g., "CREDIT_CARD"
    private String transactionId;
    private String status; // e.g., "COMPLETED"

    @OneToOne
    @JoinColumn(name = "order_id")
    private Order order;
}