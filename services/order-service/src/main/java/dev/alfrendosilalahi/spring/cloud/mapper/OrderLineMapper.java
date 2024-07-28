package dev.alfrendosilalahi.spring.cloud.mapper;

import dev.alfrendosilalahi.spring.cloud.model.Order;
import dev.alfrendosilalahi.spring.cloud.orderline.OrderLine;
import dev.alfrendosilalahi.spring.cloud.orderline.OrderLineRequest;
import org.springframework.stereotype.Service;

@Service
public class OrderLineMapper {

    public OrderLine mapOrderLineRequestToOrderLine(OrderLineRequest orderLineRequest) {
        return OrderLine.builder()
                .id(orderLineRequest.id())
                .quantity(orderLineRequest.quantity())
                .order(
                        Order.builder()
                                .id(orderLineRequest.id())
                                .build()
                )
                .productId(orderLineRequest.productId())
                .build();
    }

}

