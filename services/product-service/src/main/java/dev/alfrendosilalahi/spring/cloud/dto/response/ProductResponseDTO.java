package dev.alfrendosilalahi.spring.cloud.dto.response;

import lombok.*;

import java.math.BigDecimal;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductResponseDTO {

    private Integer id;

    private String name;

    private String description;

    private BigDecimal price;

    private Double availableQuantity;

    private Integer categoryId;

    private String categoryName;

    private String categoryDescription;

}
