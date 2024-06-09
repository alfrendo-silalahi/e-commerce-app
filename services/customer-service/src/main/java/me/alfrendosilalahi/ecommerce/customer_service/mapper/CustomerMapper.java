package me.alfrendosilalahi.ecommerce.customer_service.mapper;

import org.springframework.stereotype.Component;

import me.alfrendosilalahi.ecommerce.customer_service.dto.CustomerRequestDTO;
import me.alfrendosilalahi.ecommerce.customer_service.dto.CustomerResponseDTO;
import me.alfrendosilalahi.ecommerce.customer_service.model.Customer;

@Component
public class CustomerMapper {

    public Customer toCustomer(CustomerRequestDTO customerRequestDTO) {
        if (customerRequestDTO == null) {
            return null;
        }
        return Customer.builder()
                .id(customerRequestDTO.id())
                .firstName(customerRequestDTO.firstName())
                .lastName(customerRequestDTO.lastName())
                .email(customerRequestDTO.email())
                .address(customerRequestDTO.address())   
                .build();
    }

    public CustomerResponseDTO fromCustomer(Customer customer) {
        return new CustomerResponseDTO(
                customer.getId(), 
                customer.getFirstName(), 
                customer.getLastName(), 
                customer.getEmail(), 
                customer.getAddress()
        );
    }
    
}
