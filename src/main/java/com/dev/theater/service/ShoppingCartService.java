package com.dev.theater.service;

import com.dev.theater.model.MovieSession;
import com.dev.theater.model.ShoppingCart;
import com.dev.theater.model.User;

public interface ShoppingCartService {
    void addSession(MovieSession movieSession, User user);

    ShoppingCart getByUser(User user);

    void registerNewShoppingCart(User user);

    void clear(ShoppingCart shoppingCart);
}
