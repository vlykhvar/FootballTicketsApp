package com.dev.theater.service.impl;

import com.dev.theater.dao.UserDao;
import com.dev.theater.model.User;
import com.dev.theater.service.UserService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User add(User user) {
        return userDao.add(user);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userDao.findByEmail(email);
    }

    public List<User> getAll() {
        return userDao.getAll();
    }

    @Override
    public Optional<User> findById(Long userId) {
        return userDao.findById(userId);
    }
}
