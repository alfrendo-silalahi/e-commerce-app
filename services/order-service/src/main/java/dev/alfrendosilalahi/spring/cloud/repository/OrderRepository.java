package dev.alfrendosilalahi.spring.cloud.repository;

import dev.alfrendosilalahi.spring.cloud.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
