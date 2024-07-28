package dev.alfrendosilalahi.spring.cloud.service.implementation;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import dev.alfrendosilalahi.spring.cloud.dto.request.ProductPurchaseRequestDTO;
import dev.alfrendosilalahi.spring.cloud.dto.request.ProductRequestDTO;
import dev.alfrendosilalahi.spring.cloud.dto.response.ProductPurchaseResponseDTO;
import dev.alfrendosilalahi.spring.cloud.dto.response.ProductResponseDTO;
import dev.alfrendosilalahi.spring.cloud.exception.ProductPurchaseException;
import dev.alfrendosilalahi.spring.cloud.mapper.ProductMapper;
import dev.alfrendosilalahi.spring.cloud.model.Product;
import dev.alfrendosilalahi.spring.cloud.repository.ProductRepository;
import dev.alfrendosilalahi.spring.cloud.service.IProductService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService {

    private final ProductRepository productRepository;

    private final ProductMapper productMapper;

    @Override
    @Transactional
    public Integer createProduct(ProductRequestDTO productRequestDTO) {
        Product product = productMapper.toProduct(productRequestDTO);
        return productRepository.save(product).getId();
    }

    @Override
    public List<ProductPurchaseResponseDTO> purchaseProducts(List<ProductPurchaseRequestDTO> productPurchaseRequestDTOList) {
        List<Integer> productIdList = productPurchaseRequestDTOList
                .stream()
                .map(ProductPurchaseRequestDTO::getProductId)
                .toList();
        List<Product> storedProducts = productRepository.findAllByIdInOrderById(productIdList);

        if (productIdList.size() != storedProducts.size()) {
            throw new ProductPurchaseException("one or more products does not exists");
        }

        List<ProductPurchaseRequestDTO> sortedProductPurchaseRequestDTOList = productPurchaseRequestDTOList
                .stream()
                .sorted(Comparator.comparing(ProductPurchaseRequestDTO::getProductId))
                .toList();

        List<ProductPurchaseResponseDTO> purchasedProducts = new ArrayList<>();

        for (int i = 0; i < storedProducts.size(); i++) {
            Product product = storedProducts.get(i);
            ProductPurchaseRequestDTO productPurchaseRequestDTO = sortedProductPurchaseRequestDTOList.get(i);
            if (product.getAvailableQuantity() < productPurchaseRequestDTO.getQuantities()) {
                throw new ProductPurchaseException("insufficient stock quantity for product with id " + productPurchaseRequestDTO.getProductId());
            }
            double newAvailableQuantity = product.getAvailableQuantity() - productPurchaseRequestDTO.getQuantities();
            product.setAvailableQuantity(newAvailableQuantity);
            productRepository.save(product);
            purchasedProducts.add(productMapper.toProductPurchaseResponseDTO(product, productPurchaseRequestDTO.getQuantities()));
        }

        return purchasedProducts;
    }

    @Override
    public ProductResponseDTO findProductById(Integer productId) {
        return productRepository.findById(productId)
                .map(productMapper::toProductResponseDTO)
                .orElseThrow(() -> new EntityNotFoundException("product not found with id " + productId));
    }

    @Override
    public List<ProductResponseDTO> findAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(productMapper::toProductResponseDTO)
                .collect(Collectors.toList());
    }

}
