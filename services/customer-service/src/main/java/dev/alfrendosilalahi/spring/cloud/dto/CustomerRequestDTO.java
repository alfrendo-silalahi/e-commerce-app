package dev.alfrendosilalahi.spring.cloud.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import dev.alfrendosilalahi.spring.cloud.model.Address;

public record CustomerRequestDTO(
    String id,
    @NotNull(message = "customer first name is required") 
    String firstName,
    @NotNull(message = "customer last name is required") 
    String lastName,
    @NotNull(message = "customer email is required") 
    @Email(message = "customer email is not a valid email") 
    String email,
    Address address
) {}
