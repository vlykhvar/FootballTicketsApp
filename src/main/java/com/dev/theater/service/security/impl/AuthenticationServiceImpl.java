package com.dev.theater.service.security.impl;

import com.dev.theater.library.Service;
import com.dev.theater.model.User;
import com.dev.theater.service.UserService;
import com.dev.theater.service.impl.UserServiceImpl;
import com.dev.theater.service.security.AuthenticationService;
import com.dev.theater.util.HashUtil;
import java.util.Optional;
import javax.security.sasl.AuthenticationException;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private UserService userService = new UserServiceImpl();

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
