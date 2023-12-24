package com.quixoticquisine.kitchenservice.domain;

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
@Table(name = "ticket")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TicketEntity {
    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TicketStatusEnum ticketStatus;
    @OneToMany(targetEntity = TicketItemEntity.class,
            cascade = ALL,
            fetch = FetchType.LAZY, mappedBy = "ticketEntity", orphanRemoval = true)
    private final Set<TicketItemEntity> ticketItems = new HashSet<>();
    @Column(nullable = false)
    private UUID orderId;
    private String consumerComment;

    public void setTicketItems(Set<TicketItemEntity> ticketItems) {
        ticketItems.forEach(orderItem -> orderItem.setTicketEntity(this));
        this.ticketItems.clear();
        this.ticketItems.addAll(ticketItems);
    }
}
