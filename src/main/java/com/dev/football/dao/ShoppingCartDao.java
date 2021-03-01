package com.dev.football.dao;

import com.dev.football.model.ShoppingCart;
import com.dev.football.model.User;

public interface ShoppingCartDao extends GenericDao<ShoppingCart> {
    ShoppingCart getByUser(User user);

    void update(ShoppingCart shoppingCart);
}
