package dev.alfrendosilalahi.spring.cloud.dto;

import dev.alfrendosilalahi.spring.cloud.model.PaymentMethod;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.util.List;

public record OrderRequestDTO(
        Integer id,
        String reference,
        @Positive(message = "order amount should be positive")
        BigDecimal amount,
        @NotNull(message = "payment method should be precised")
        PaymentMethod paymentMethod,
        @NotNull(message = "customer should be present")
        @NotEmpty(message = "customer should be not empty")
        @NotBlank(message = "customer should be not blank")
        String customerId,
        @NotEmpty(message = "you should at least purchase one product")
        List<PurchaseRequestDTO> products
) {
}
