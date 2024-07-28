package dev.alfrendosilalahi.spring.cloud.mapper;

import dev.alfrendosilalahi.spring.cloud.dto.OrderRequestDTO;
import dev.alfrendosilalahi.spring.cloud.model.Order;
import org.springframework.stereotype.Service;

@Service
public class OrderMapper {

    public Order mapOrderRequestDTOToOrder(OrderRequestDTO orderRequestDTO) {
        return Order.builder()
                .id(orderRequestDTO.id())
                .customerId(orderRequestDTO.customerId())
                .reference(orderRequestDTO.reference())
                .totalAmount(orderRequestDTO.amount())
                .paymentMethod(orderRequestDTO.paymentMethod())
                .build();
    }

}
