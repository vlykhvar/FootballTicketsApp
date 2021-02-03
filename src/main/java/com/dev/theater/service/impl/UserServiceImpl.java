package com.dev.theater.service.impl;

import com.dev.theater.dao.UserDao;
import com.dev.theater.dao.impl.UserDaoImpl;
import com.dev.theater.library.Inject;
import com.dev.theater.library.Service;
import com.dev.theater.model.User;
import com.dev.theater.service.UserService;
import com.dev.theater.service.security.AuthenticationService;
import com.dev.theater.util.HashUtil;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();
    @Inject
    private AuthenticationService authenticationService;

    @Override
    public User add(User user) {
        byte[] salt = HashUtil.getSalt();
        user.setSalt(salt);
        String hashedPassword = HashUtil.hashPassword(user.getPassword(), salt);
        user.setPassword(hashedPassword);
        return userDao.add(user);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userDao.findByEmail(email);
    }
}
