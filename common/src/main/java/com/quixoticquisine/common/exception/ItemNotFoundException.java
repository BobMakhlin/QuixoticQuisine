package com.quixoticquisine.common.exception;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class ItemNotFoundException extends RuntimeException {
    private final UUID id;

    public ItemNotFoundException(UUID id) {
        super(String.format("Item with id %s not found", id));
        this.id = id;
    }

    public ItemNotFoundException(String message, UUID id) {
        super(message);
        this.id = id;
    }
}
