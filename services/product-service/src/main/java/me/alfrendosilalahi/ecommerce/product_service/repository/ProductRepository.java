package me.alfrendosilalahi.ecommerce.product_service.repository;

import me.alfrendosilalahi.ecommerce.product_service.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findAllByIdInOrderById(List<Integer> productIdList);

}
