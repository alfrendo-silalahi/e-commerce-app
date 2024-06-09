package me.alfrendosilalahi.ecommerce.customer_service.dto;

import me.alfrendosilalahi.ecommerce.customer_service.model.Address;

public record CustomerResponseDTO(
    String id,
    String firstName, 
    String lastName,  
    String email,
    Address address
) {}
