package dev.alfrendosilalahi.spring.cloud.service;

import dev.alfrendosilalahi.spring.cloud.mapper.OrderLineMapper;
import dev.alfrendosilalahi.spring.cloud.orderline.OrderLine;
import dev.alfrendosilalahi.spring.cloud.orderline.OrderLineRequest;
import dev.alfrendosilalahi.spring.cloud.repository.OrderLineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DefaultOrderLineService implements OrderLineService {

    private final OrderLineRepository orderLineRepository;

    private final OrderLineMapper orderLineMapper;

    @Override
    public Integer saveOrderLine(OrderLineRequest orderLineRequest) {
        OrderLine orderLine = orderLineMapper.mapOrderLineRequestToOrderLine(orderLineRequest);
        return orderLineRepository.save(orderLine).getId();
    }

}
