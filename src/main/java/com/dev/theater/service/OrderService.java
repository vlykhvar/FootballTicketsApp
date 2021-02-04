package com.dev.theater.service;

import com.dev.theater.model.Order;
import com.dev.theater.model.ShoppingCart;
import com.dev.theater.model.User;
import java.util.List;

public interface OrderService {
    Order completeOrder(ShoppingCart shoppingCart);

    List<Order> getOrdersHistory(User user);
}
