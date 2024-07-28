package dev.alfrendosilalahi.spring.cloud.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record PurchaseRequestDTO(
        @NotNull(message = "product is mandatory")
        Integer productId,
        @Positive(message = "quantity is mandatory")
        Double quantity
) {
}
