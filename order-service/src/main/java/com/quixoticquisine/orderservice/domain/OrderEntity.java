package com.quixoticquisine.orderservice.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import static jakarta.persistence.CascadeType.ALL;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderEntity {
    @OneToMany(targetEntity = OrderItemEntity.class,
            cascade = ALL,
            fetch = FetchType.LAZY, mappedBy = "orderEntity", orphanRemoval = true)
    private final Set<OrderItemEntity> orderItems = new HashSet<>();
    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;
    private UUID consumerId;
    private UUID restaurantId;
    @Enumerated(EnumType.STRING)
    private OrderStatusEnum orderStatus;

    public void setOrderItems(Set<OrderItemEntity> orderItems) {
        orderItems.forEach(orderItem -> orderItem.setOrderEntity(this));
        this.orderItems.clear();
        this.orderItems.addAll(orderItems);
    }
}
