package dev.alfrendosilalahi.spring.cloud.orderline;

import jakarta.persistence.*;
import lombok.*;
import dev.alfrendosilalahi.spring.cloud.model.Order;

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
