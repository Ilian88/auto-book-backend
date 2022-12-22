package com.example.autobookrest.exception;

public class UserAlreadyExistsException extends RuntimeException{
    public UserAlreadyExistsException(String exception) {
        super(exception);
    }
}
