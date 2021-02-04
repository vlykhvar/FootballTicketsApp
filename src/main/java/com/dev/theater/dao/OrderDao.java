package com.dev.theater.dao;

import com.dev.theater.model.Order;
import com.dev.theater.model.User;
import java.util.List;

public interface OrderDao extends GenericDao<Order> {
    List<Order> getOrdersHistory(User user);
}
