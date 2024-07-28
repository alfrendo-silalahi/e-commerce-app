package dev.alfrendosilalahi.spring.cloud.mapper;

import dev.alfrendosilalahi.spring.cloud.dto.CustomerRequestDTO;
import dev.alfrendosilalahi.spring.cloud.model.Customer;
import org.springframework.stereotype.Component;

import dev.alfrendosilalahi.spring.cloud.dto.CustomerResponseDTO;

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
