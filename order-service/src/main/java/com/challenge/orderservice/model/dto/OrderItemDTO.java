package com.challenge.orderservice.model.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class OrderItemDTO {
    @NotNull(message = "Product ID is required")
    private Long productId;
    @Min(value = 1, message = "Quantity must be at least 1")
    private Integer quantity;
    @Positive(message = "Price must be greater than zero")
    private Double price;
}