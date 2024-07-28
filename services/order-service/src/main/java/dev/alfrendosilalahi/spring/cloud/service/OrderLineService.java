package dev.alfrendosilalahi.spring.cloud.service;

import dev.alfrendosilalahi.spring.cloud.orderline.OrderLineRequest;

public interface OrderLineService {


    Integer saveOrderLine(OrderLineRequest orderLineRequest);
}
