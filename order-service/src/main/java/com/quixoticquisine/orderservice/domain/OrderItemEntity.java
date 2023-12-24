package com.quixoticquisine.orderservice.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.Objects;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "order_item", uniqueConstraints = @UniqueConstraint(
        name = OrderConstraints.PRODUCT_ORDER_UNIQUE, columnNames = {"order_id", "product_id"}))
public class OrderItemEntity {
    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID orderItemId;
    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private OrderEntity orderEntity;
    @Column(name = "product_id", nullable = false)
    private UUID productId;
    @Column(nullable = false)
    private Integer amount;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItemEntity that = (OrderItemEntity) o;
        return Objects.equals(getOrderItemId(), that.getOrderItemId())
                && Objects.equals(getOrderEntity(), that.getOrderEntity())
                && Objects.equals(getProductId(), that.getProductId())
                && Objects.equals(getAmount(), that.getAmount());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOrderItemId(),
                getOrderEntity(),
                getProductId(),
                getAmount());
    }
}
