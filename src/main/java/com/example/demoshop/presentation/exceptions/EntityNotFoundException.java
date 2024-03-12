package com.example.demoshop.presentation.exceptions;

public class EntityNotFoundException  extends RuntimeException {

    public EntityNotFoundException(String message) {
        super(message);
    }
}
