package com.quixoticquisine.consumerservice.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "consumer")
public class ConsumerEntity {
    @Id
    private UUID id;
    @Column(nullable = false)
    private String userName;
    @Column(nullable = false)
    private boolean active;
}
