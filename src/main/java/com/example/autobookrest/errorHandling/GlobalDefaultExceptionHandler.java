package com.example.autobookrest.errorHandling;

import com.example.autobookrest.exception.NoSuchUserException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalDefaultExceptionHandler {

    @ExceptionHandler(value = {NoSuchUserException.class})
    public ResponseEntity<ApiError> noSuchUser(NoSuchUserException ex) {
        return ResponseEntity.badRequest().body(new ApiError(ex.getMessage(), "400", "Username or userId is wrong"));
    }
}
