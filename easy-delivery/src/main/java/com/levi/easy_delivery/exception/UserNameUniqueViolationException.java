package com.levi.easy_delivery.exception;

public class UserNameUniqueViolationException extends RuntimeException {
    public UserNameUniqueViolationException(String message) {
        super(message);
    }
}