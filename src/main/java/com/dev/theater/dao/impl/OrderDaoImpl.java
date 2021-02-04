package com.dev.theater.dao.impl;

import com.dev.theater.dao.OrderDao;
import com.dev.theater.exception.CrudException;
import com.dev.theater.library.Dao;
import com.dev.theater.model.Order;
import com.dev.theater.model.User;
import com.dev.theater.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;

@Dao
public class OrderDaoImpl extends DaoImpl<Order> implements OrderDao {
    @Override
    public List<Order> getOrdersHistory(User user) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Order o inner join fetch o.tickets"
                    + " where o.user = :user", Order.class)
                    .setParameter("user", user)
                    .getResultList();
        } catch (Exception e) {
            throw new CrudException("Could not find history for: " + user, e);
        }
    }
}
