package dev.alfrendosilalahi.spring.cloud.dto;

public record CustomerResponseDTO(
    String id,
    String firstName, 
    String lastName,  
    String email
) {}
