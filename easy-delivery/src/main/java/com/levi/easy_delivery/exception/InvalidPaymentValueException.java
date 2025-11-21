package com.levi.easy_delivery.exception;

public class InvalidPaymentValueException extends RuntimeException {
    public InvalidPaymentValueException(String message) {
        super(message);
    }
}