package dev.alfrendosilalahi.spring.cloud.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import dev.alfrendosilalahi.spring.cloud.dto.request.ProductPurchaseRequestDTO;
import dev.alfrendosilalahi.spring.cloud.dto.request.ProductRequestDTO;
import dev.alfrendosilalahi.spring.cloud.dto.response.ProductPurchaseResponseDTO;
import dev.alfrendosilalahi.spring.cloud.dto.response.ProductResponseDTO;
import dev.alfrendosilalahi.spring.cloud.service.IProductService;
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
