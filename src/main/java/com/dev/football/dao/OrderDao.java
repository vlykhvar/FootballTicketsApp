package com.dev.football.dao;

import com.dev.football.model.Order;
import com.dev.football.model.User;
import java.util.List;

public interface OrderDao extends GenericDao<Order> {
    List<Order> getOrdersHistory(User user);
}
