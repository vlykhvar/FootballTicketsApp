package com.dev.theater.security.impl;

import com.dev.theater.exception.AuthenticationException;
import com.dev.theater.model.User;
import com.dev.theater.security.AuthenticationService;
import com.dev.theater.service.ShoppingCartService;
import com.dev.theater.service.UserService;
import com.dev.theater.util.HashUtil;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private UserService userService;
    private ShoppingCartService shoppingCartService;

    @Autowired
    AuthenticationServiceImpl(UserService userService, ShoppingCartService shoppingCartService) {
        this.userService = userService;
        this.shoppingCartService = shoppingCartService;
    }

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
        userService.add(newUser);
        shoppingCartService.registerNewShoppingCart(newUser);
        return newUser;
    }
}
