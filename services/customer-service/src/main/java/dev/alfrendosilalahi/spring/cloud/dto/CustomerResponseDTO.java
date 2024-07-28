package dev.alfrendosilalahi.spring.cloud.dto;

import dev.alfrendosilalahi.spring.cloud.model.Address;

public record CustomerResponseDTO(
    String id,
    String firstName, 
    String lastName,  
    String email,
    Address address
) {}
