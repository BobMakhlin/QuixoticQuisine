package com.quixoticquisine.kitchenservice.domain;

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
@Table(name = "ticket_item", uniqueConstraints = @UniqueConstraint(
        name = TicketConstraints.PRODUCT_TICKET_UNIQUE, columnNames = {"ticket_id", "product_id"}))
public class TicketItemEntity {
    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID ticketItemId;
    @ManyToOne
    @JoinColumn(name = "ticket_id", nullable = false)
    private TicketEntity ticketEntity;
    @Column(name = "product_id", nullable = false)
    private UUID productId;
    @Column(nullable = false)
    private Integer amount;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TicketItemEntity that = (TicketItemEntity) o;
        return Objects.equals(getTicketItemId(), that.getTicketItemId())
                && Objects.equals(getTicketEntity(), that.getTicketEntity())
                && Objects.equals(getProductId(), that.getProductId())
                && Objects.equals(getAmount(), that.getAmount());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTicketItemId(),
                getTicketEntity(),
                getProductId(),
                getAmount());
    }
}
