package me.alfrendosilalahi.ecommerce.product_service.dto.response;

import lombok.*;

import java.math.BigDecimal;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductPurchaseResponseDTO {

    private Integer productId;

    private String name;

    private String description;

    private BigDecimal price;

    private Double quantity;

}
