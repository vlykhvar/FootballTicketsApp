package com.dev.theater.dao;

import com.dev.theater.model.ShoppingCart;
import com.dev.theater.model.User;

public interface ShoppingCartDao extends GenericDao<ShoppingCart> {
    ShoppingCart getByUser(User user);

    void update(ShoppingCart shoppingCart);
}
