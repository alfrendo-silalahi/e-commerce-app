package dev.alfrendosilalahi.spring.cloud.feign;

import dev.alfrendosilalahi.spring.cloud.dto.CustomerResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(
        name = "customer-service",
        url = "${application.config.customer-url}"
)
public interface CustomerClient {

    @GetMapping("/{customer_id}")
    Optional<CustomerResponseDTO> findCustomerById(@PathVariable("customer_id") String customerId);

}
