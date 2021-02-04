package com.dev.theater.service.impl;

import com.dev.theater.dao.OrderDao;
import com.dev.theater.library.Inject;
import com.dev.theater.library.Service;
import com.dev.theater.model.Order;
import com.dev.theater.model.ShoppingCart;
import com.dev.theater.model.User;
import com.dev.theater.service.OrderService;
import com.dev.theater.service.ShoppingCartService;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Inject
    private OrderDao orderDao;
    @Inject
    private ShoppingCartService shoppingCartService;

    @Override
    public Order completeOrder(ShoppingCart shoppingCart) {
        Order order = new Order();
        order.setOrderTime(LocalDateTime.now());
        order.setUser(shoppingCart.getUser());
        order.setTickets(new ArrayList<>(shoppingCart.getTicketList()));
        orderDao.add(order);
        shoppingCartService.clear(shoppingCart);
        return order;
    }

    @Override
    public List<Order> getOrdersHistory(User user) {
        return orderDao.getOrdersHistory(user);
    }
}
