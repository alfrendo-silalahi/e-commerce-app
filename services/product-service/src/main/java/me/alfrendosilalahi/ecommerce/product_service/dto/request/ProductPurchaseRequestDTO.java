package me.alfrendosilalahi.ecommerce.product_service.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductPurchaseRequestDTO {

    @NotNull(message = "product is mandatory")
    private Integer productId;

    @NotNull(message = "quantities id mandatory")
    private Double quantities;

}
