package com.challenge.orderservice.controller;

import com.challenge.orderservice.model.dto.OrderRequestDTO;
import com.challenge.orderservice.model.entity.Order;
import com.challenge.orderservice.service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<Order> createOrder(@Valid @RequestBody OrderRequestDTO orderRequest) {
        return ResponseEntity.ok(orderService.createOrder(orderRequest));
    }

    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.findAllOrders();
    }
}