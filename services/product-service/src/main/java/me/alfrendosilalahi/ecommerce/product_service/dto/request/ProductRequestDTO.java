package me.alfrendosilalahi.ecommerce.product_service.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequestDTO {

    Integer id;

    @NotNull(message = "product name is required")
    String name;

    @NotNull(message = "product description is required")
    String description;

    @Positive(message = "product should be positive")
    BigDecimal price;

    @Positive(message = "available quantity should be positive")
    Double availableQuantity;

    @NotNull(message = "product category is required")
    Integer categoryId;

}
