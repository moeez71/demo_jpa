package com.demo_jpa.exceptionhandling;

public class AnyCustomException extends RuntimeException{
    public AnyCustomException(String message) {
        super(message);
    }
}
