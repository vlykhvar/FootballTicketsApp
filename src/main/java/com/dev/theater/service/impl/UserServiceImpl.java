package com.dev.theater.service.impl;

import com.dev.theater.dao.UserDao;
import com.dev.theater.library.Inject;
import com.dev.theater.library.Service;
import com.dev.theater.model.User;
import com.dev.theater.service.UserService;
import com.dev.theater.util.HashUtil;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Inject
    private UserDao userDao;

    @Override
    public User add(User user) {
        byte[] salt = HashUtil.getSalt();
        user.setSalt(salt);
        user.setPassword(HashUtil.hashPassword(user.getPassword(), salt));
        return userDao.add(user);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userDao.findByEmail(email);
    }

    public List<User> getAll() {
        return userDao.getAll();
    }
}
