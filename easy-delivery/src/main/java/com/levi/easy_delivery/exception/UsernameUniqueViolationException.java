package com.levi.easy_delivery.exception;

public class UsernameUniqueViolationException extends RuntimeException {
    public UsernameUniqueViolationException(String message) {
        super(message);
    }
}