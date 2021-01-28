package com.dev.theater.exception;

public class CrudException extends RuntimeException {
    public CrudException(String message, Throwable cause) {
        super(message, cause);
    }

    public CrudException(String message) {
        super(message);
    }
}
