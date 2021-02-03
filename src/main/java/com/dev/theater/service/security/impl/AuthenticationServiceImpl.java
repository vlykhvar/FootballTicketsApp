package com.dev.theater.service.security.impl;

import com.dev.theater.exception.AuthenticationException;
import com.dev.theater.library.Inject;
import com.dev.theater.library.Service;
import com.dev.theater.model.User;
import com.dev.theater.service.UserService;
import com.dev.theater.service.security.AuthenticationService;
import com.dev.theater.util.HashUtil;
import java.util.Optional;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    @Inject
    private UserService userService;

    @Override
    public User login(String email, String password) throws AuthenticationException {
        Optional<User> user = userService.findByEmail(email);
        if (user.isPresent() && user.get().getPassword()
                .equals(HashUtil.hashPassword(password, user.get().getSalt()))) {
            return user.get();
        }
        throw new AuthenticationException("Can`t authenticate user with email:" + email);
    }

    @Override
    public User register(String email, String password) {
        User newUser = new User();
        newUser.setEmail(email);
        newUser.setPassword(password);
        return userService.add(newUser);
    }
}
