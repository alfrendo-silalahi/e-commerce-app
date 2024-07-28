package dev.alfrendosilalahi.spring.cloud.repository;

import dev.alfrendosilalahi.spring.cloud.orderline.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderLineRepository extends JpaRepository<OrderLine, Integer> {
}
