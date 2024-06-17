package me.alfrendosilalahi.ecommerce.product_service.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import me.alfrendosilalahi.ecommerce.product_service.dto.request.ProductPurchaseRequestDTO;
import me.alfrendosilalahi.ecommerce.product_service.dto.request.ProductRequestDTO;
import me.alfrendosilalahi.ecommerce.product_service.dto.response.ProductPurchaseResponseDTO;
import me.alfrendosilalahi.ecommerce.product_service.dto.response.ProductResponseDTO;
import me.alfrendosilalahi.ecommerce.product_service.service.IProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final IProductService productService;

    @PostMapping
    public ResponseEntity<Integer> createProduct(
            @RequestBody @Valid ProductRequestDTO productRequestDTO
    ) {
        return ResponseEntity.ok(productService.createProduct(productRequestDTO));
    }

    @PostMapping("/purchase")
    public ResponseEntity<List<ProductPurchaseResponseDTO>> purchaseProducts(
            @RequestBody List<ProductPurchaseRequestDTO> productPurchaseRequestDTOList
    ) {
        return ResponseEntity.ok(productService.purchaseProducts(productPurchaseRequestDTOList));
    }

    @GetMapping("/{product-id}")
    public ResponseEntity<ProductResponseDTO> findProductById(
            @PathVariable("product-id") Integer productId
    ) {
        return ResponseEntity.ok(productService.findProductById(productId));
    }

    @GetMapping
    public ResponseEntity<List<ProductResponseDTO>> findAllProducts() {
        return ResponseEntity.ok(productService.findAllProducts());
    }

}
