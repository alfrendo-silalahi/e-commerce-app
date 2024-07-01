package me.alfrendosilalahi.ecommerce.order_service.orderline;

import jakarta.persistence.*;
import lombok.*;
import me.alfrendosilalahi.ecommerce.order_service.model.Order;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@Entity
@Table(name = "order_line")
public class OrderLine {

    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    private Integer productId;

    private double quantity;

}
