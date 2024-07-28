package dev.alfrendosilalahi.spring.cloud.dto;

import java.math.BigDecimal;

public record PurchaseResponseDTO(
        Integer productId,
        String name,
        String description,
        BigDecimal price,
        double quantity
) {
}
