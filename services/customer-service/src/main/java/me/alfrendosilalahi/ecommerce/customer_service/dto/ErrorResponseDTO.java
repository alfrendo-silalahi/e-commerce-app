package me.alfrendosilalahi.ecommerce.customer_service.dto;

import java.util.Map;

public record ErrorResponseDTO(
    Map<String, String> error
) {}
