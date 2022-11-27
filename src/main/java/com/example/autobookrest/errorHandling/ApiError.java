package com.example.autobookrest.errorHandling;

public class ApiError {
    private String message;
    private String errorCode;
    private String cause;

    public ApiError(String message, String errorCode, String cause) {
        this.message = message;
        this.errorCode = errorCode;
        this.cause = cause;
    }

    public String getMessage() {
        return message;
    }

    public ApiError setMessage(String message) {
        this.message = message;
        return this;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public ApiError setErrorCode(String errorCode) {
        this.errorCode = errorCode;
        return this;
    }

    public String getCause() {
        return cause;
    }

    public ApiError setCause(String cause) {
        this.cause = cause;
        return this;
    }
}
