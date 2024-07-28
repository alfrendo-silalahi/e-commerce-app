package dev.alfrendosilalahi.spring.cloud.service;

import dev.alfrendosilalahi.spring.cloud.exception.BusinessException;
import dev.alfrendosilalahi.spring.cloud.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import dev.alfrendosilalahi.spring.cloud.dto.CustomerResponseDTO;
import dev.alfrendosilalahi.spring.cloud.dto.OrderRequestDTO;
import dev.alfrendosilalahi.spring.cloud.feign.CustomerClient;
import dev.alfrendosilalahi.spring.cloud.rest.ProductClient;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OrderService implements IOrderService {

    private final CustomerClient customerClient;

    private final ProductClient productClient;

    private final OrderRepository orderRepository;

    @Override
    @Transactional
    public Integer createOrder(OrderRequestDTO orderRequestDTO) {
        // check the customer --> customer-service (feign)
        CustomerResponseDTO customerResponseDTO = customerClient.findCustomerById(orderRequestDTO.customerId())
                .orElseThrow(() -> new BusinessException("cannot create order :: no customer exist with the provided id"));

        // purchase the products --> product-service (rest template)
        productClient.purchaseProducts(orderRequestDTO.products());

        // persist order


        // persist order lines

        // start payment process

        // send the order confirmation --> notification-service (kafka)
    }

}
