package me.alfrendosilalahi.ecommerce.product_service.service;

import me.alfrendosilalahi.ecommerce.product_service.dto.request.ProductPurchaseRequestDTO;
import me.alfrendosilalahi.ecommerce.product_service.dto.request.ProductRequestDTO;
import me.alfrendosilalahi.ecommerce.product_service.dto.response.ProductPurchaseResponseDTO;
import me.alfrendosilalahi.ecommerce.product_service.dto.response.ProductResponseDTO;

import java.util.List;

public interface IProductService {

    Integer createProduct(ProductRequestDTO productRequestDTO);

    List<ProductPurchaseResponseDTO> purchaseProducts(List<ProductPurchaseRequestDTO> productPurchaseRequestDTOList);

    ProductResponseDTO findProductById(Integer productId);

    List<ProductResponseDTO> findAllProducts();

}
