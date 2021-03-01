package com.dev.football.exception;

public class CrudException extends RuntimeException {
    public CrudException(String message, Throwable cause) {
        super(message, cause);
    }

    public CrudException(String message) {
        super(message);
    }
}
