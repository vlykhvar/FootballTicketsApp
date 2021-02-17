package com.dev.theater.dao;

import com.dev.theater.model.User;
import java.util.List;
import java.util.Optional;

public interface UserDao extends GenericDao<User> {
    List<User> getAll();

    Optional<User> findByEmail(String email);

    Optional<User> findById(Long userId);
}
