package com.example.autobookrest.errorHandling;

import com.example.autobookrest.exception.NoSuchUserException;
import com.example.autobookrest.exception.UserAlreadyExistsException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
public class GlobalDefaultExceptionHandler {

    @ExceptionHandler(value = {NoSuchUserException.class})
    public ResponseEntity<ApiError> noSuchUser(NoSuchUserException ex) {
        return ResponseEntity.badRequest().body(new ApiError(ex.getMessage(), "400", "Username or userId is wrong"));
    }

    @ExceptionHandler(value = {UserAlreadyExistsException.class})
    public ResponseEntity<ApiError> userExists(UserAlreadyExistsException ex) {
        return ResponseEntity.badRequest().body(new ApiError(ex.getMessage(), "400", "User already exists"));
    }
}
