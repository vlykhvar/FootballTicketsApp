package com.dev.football.service;

import com.dev.football.model.Order;
import com.dev.football.model.ShoppingCart;
import com.dev.football.model.User;
import java.util.List;

public interface OrderService {
    Order completeOrder(ShoppingCart shoppingCart);

    List<Order> getOrdersHistory(User user);
}
