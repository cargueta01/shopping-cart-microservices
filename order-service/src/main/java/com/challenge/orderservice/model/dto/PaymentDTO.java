package com.challenge.orderservice.model.dto;

import lombok.Data;

@Data
public class PaymentDTO {
    private Long orderId;
    private String paymentMethod;
    private Double amount;
}