package dev.alfrendosilalahi.spring.cloud.service;

import dev.alfrendosilalahi.spring.cloud.dto.request.ProductPurchaseRequestDTO;
import dev.alfrendosilalahi.spring.cloud.dto.request.ProductRequestDTO;
import dev.alfrendosilalahi.spring.cloud.dto.response.ProductPurchaseResponseDTO;
import dev.alfrendosilalahi.spring.cloud.dto.response.ProductResponseDTO;

import java.util.List;

public interface IProductService {

    Integer createProduct(ProductRequestDTO productRequestDTO);

    List<ProductPurchaseResponseDTO> purchaseProducts(List<ProductPurchaseRequestDTO> productPurchaseRequestDTOList);

    ProductResponseDTO findProductById(Integer productId);

    List<ProductResponseDTO> findAllProducts();

}
