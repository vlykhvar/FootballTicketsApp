package com.dev.football.service;

import com.dev.football.model.User;
import java.util.List;
import java.util.Optional;

public interface UserService {
    User add(User user);

    Optional<User> findByEmail(String email);

    List<User> getAll();

    Optional<User> findById(Long userId);
}
