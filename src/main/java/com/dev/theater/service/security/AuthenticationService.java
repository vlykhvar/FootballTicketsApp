package com.dev.theater.service.security;

import com.dev.theater.exception.AuthenticationException;
import com.dev.theater.model.User;

public interface AuthenticationService {
    User login(String email, String password) throws AuthenticationException;

    User register(String email, String password);
}
