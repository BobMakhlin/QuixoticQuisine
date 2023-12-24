package com.quixoticquisine.consumerservice.repository;

import com.quixoticquisine.consumerservice.domain.ConsumerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ConsumerRepository extends JpaRepository<ConsumerEntity, UUID> {
}
