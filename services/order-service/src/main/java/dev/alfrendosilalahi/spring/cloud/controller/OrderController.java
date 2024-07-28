package dev.alfrendosilalahi.spring.cloud.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import dev.alfrendosilalahi.spring.cloud.dto.OrderRequestDTO;
import dev.alfrendosilalahi.spring.cloud.service.IOrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {

    private final IOrderService orderService;

    @PostMapping
    public ResponseEntity<Integer> createOrder(@RequestBody @Valid OrderRequestDTO orderRequestDTO) {
        return ResponseEntity.ok(orderService.createOrder(orderRequestDTO));
    }


}
