package com.challenge.orderservice.service;

import com.challenge.orderservice.model.dto.OrderRequestDTO;
import com.challenge.orderservice.model.entity.Order;
import com.challenge.orderservice.model.entity.OrderDetail;
import com.challenge.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    @Transactional //for to sure that the order is saved only if all details are saved correctly
    public Order createOrder(OrderRequestDTO orderRequest) {
        Order order = new Order();
        order.setOrderDate(LocalDateTime.now());
        order.setStatus("PENDING");

        List<OrderDetail> details = orderRequest.getItems().stream().map(item -> {
            OrderDetail detail = new OrderDetail();
            detail.setProductId(item.getProductId());
            detail.setQuantity(item.getQuantity());
            detail.setUnitPrice(item.getPrice());
            detail.setOrder(order);
            return detail;
        }).collect(Collectors.toList());

        order.setDetails(details);

        Double total = details.stream()
                .mapToDouble(d -> d.getUnitPrice() * d.getQuantity())
                .sum();
        order.setTotalAmount(total);

        return orderRepository.save(order);
    }

    public List<Order> findAllOrders() {
        return orderRepository.findAll();
    }
}