package com.example.autobookrest.exception;

public class NoSuchUserException extends RuntimeException {
    public NoSuchUserException(String exception) {
        super(exception);
    }
}
