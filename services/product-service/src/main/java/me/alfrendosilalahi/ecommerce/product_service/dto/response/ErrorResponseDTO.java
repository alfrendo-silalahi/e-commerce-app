package me.alfrendosilalahi.ecommerce.product_service.dto.response;

import java.util.Map;

public record ErrorResponseDTO(
        Map<String, String> error
) {
}
