package dev.alfrendosilalahi.spring.cloud.mapper;

import dev.alfrendosilalahi.spring.cloud.model.Product;
import dev.alfrendosilalahi.spring.cloud.dto.request.ProductRequestDTO;
import dev.alfrendosilalahi.spring.cloud.dto.response.ProductPurchaseResponseDTO;
import dev.alfrendosilalahi.spring.cloud.dto.response.ProductResponseDTO;
import dev.alfrendosilalahi.spring.cloud.model.Category;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public Product toProduct(ProductRequestDTO productRequestDTO) {
        return Product.builder()
                .id(productRequestDTO.getId())
                .name(productRequestDTO.getName())
                .description(productRequestDTO.getDescription())
                .price(productRequestDTO.getPrice())
                .availableQuantity(productRequestDTO.getAvailableQuantity())
                .category(Category.builder().id(productRequestDTO.getCategoryId()).build())
                .build();
    }

    public ProductResponseDTO toProductResponseDTO(Product product) {
        return ProductResponseDTO.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .availableQuantity(product.getAvailableQuantity())
                .categoryId(product.getCategory().getId())
                .categoryName(product.getCategory().getName())
                .categoryDescription(product.getCategory().getDescription())
                .build();
    }

    public ProductPurchaseResponseDTO toProductPurchaseResponseDTO(Product product, Double quantities) {
        return ProductPurchaseResponseDTO.builder()
                .productId(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .quantity(quantities)
                .build();
    }

}
