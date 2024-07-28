package dev.alfrendosilalahi.spring.cloud.service;

import dev.alfrendosilalahi.spring.cloud.dto.OrderRequestDTO;

public interface IOrderService {

    Integer createOrder(OrderRequestDTO orderRequestDTO);

}
