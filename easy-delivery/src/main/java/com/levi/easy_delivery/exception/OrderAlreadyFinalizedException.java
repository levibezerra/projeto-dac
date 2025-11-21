package com.levi.easy_delivery.exception;

public class OrderAlreadyFinalizedException extends RuntimeException {
    public OrderAlreadyFinalizedException(String message) {
        super(message);
    }
}