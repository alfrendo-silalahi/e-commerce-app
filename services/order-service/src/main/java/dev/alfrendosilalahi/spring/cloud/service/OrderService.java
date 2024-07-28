package dev.alfrendosilalahi.spring.cloud.service;

import dev.alfrendosilalahi.spring.cloud.dto.CustomerResponseDTO;
import dev.alfrendosilalahi.spring.cloud.dto.OrderRequestDTO;
import dev.alfrendosilalahi.spring.cloud.dto.PurchaseRequestDTO;
import dev.alfrendosilalahi.spring.cloud.exception.BusinessException;
import dev.alfrendosilalahi.spring.cloud.feign.CustomerClient;
import dev.alfrendosilalahi.spring.cloud.mapper.OrderMapper;
import dev.alfrendosilalahi.spring.cloud.model.Order;
import dev.alfrendosilalahi.spring.cloud.orderline.OrderLineRequest;
import dev.alfrendosilalahi.spring.cloud.repository.OrderRepository;
import dev.alfrendosilalahi.spring.cloud.rest.ProductClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OrderService implements IOrderService {

    private final CustomerClient customerClient;

    private final ProductClient productClient;

    private final OrderRepository orderRepository;

    private final OrderMapper orderMapper;

    private final OrderLineService orderLineService;

    @Override
    @Transactional
    public Integer createOrder(OrderRequestDTO orderRequestDTO) {
        // check the customer --> customer-service (feign)
        CustomerResponseDTO customerResponseDTO = customerClient.findCustomerById(orderRequestDTO.customerId())
                .orElseThrow(() -> new BusinessException("cannot create order :: no customer exist with the provided id"));

        // purchase the products --> product-service (rest template)
        productClient.purchaseProducts(orderRequestDTO.products());

        // persist order
        Order order = orderRepository.save(orderMapper.mapOrderRequestDTOToOrder(orderRequestDTO));

        // persist order lines
        for (PurchaseRequestDTO purchaseRequestDTO : orderRequestDTO.products()) {
            orderLineService.saveOrderLine(
                    new OrderLineRequest(
                            null,
                            order.getId(),
                            purchaseRequestDTO.productId(),
                            purchaseRequestDTO.quantity()
                    )
            );
        }

        // TODO: start payment process

        // TODO: send the order confirmation --> notification-service (kafka)

        return null;
    }

}
