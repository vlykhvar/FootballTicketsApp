package com.dev.theater.security;

import com.dev.theater.model.User;

public interface AuthenticationService {
    User register(String email, String password);
}
