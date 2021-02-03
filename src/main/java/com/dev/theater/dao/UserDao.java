package com.dev.theater.dao;

import com.dev.theater.model.User;
import java.util.List;
import java.util.Optional;

public interface UserDao extends Dao<User> {
    List<User> getAll();

    Optional<User> findByEmail(String email);
}
