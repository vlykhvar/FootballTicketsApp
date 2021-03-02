package com.dev.football.security;

import com.dev.football.model.User;

public interface AuthenticationService {
    User register(String email, String password);
}
