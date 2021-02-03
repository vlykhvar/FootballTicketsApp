package com.dev.theater.exception;

import javax.security.sasl.SaslException;

public class AuthenticationException extends SaslException {
    public AuthenticationException(String message, Throwable cause) {
        super(message, cause);
    }

    public AuthenticationException(String message) {
        super(message);
    }
}
