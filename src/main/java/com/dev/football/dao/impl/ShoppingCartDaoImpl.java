package com.dev.football.dao.impl;

import com.dev.football.dao.ShoppingCartDao;
import com.dev.football.exception.CrudException;
import com.dev.football.model.ShoppingCart;
import com.dev.football.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ShoppingCartDaoImpl extends DaoImpl<ShoppingCart> implements ShoppingCartDao {
    @Autowired
    public ShoppingCartDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public ShoppingCart getByUser(User user) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from ShoppingCart sc left join fetch sc.tickets"
                + " where sc.user = :user", ShoppingCart.class)
                .setParameter("user", user).getSingleResult();
        } catch (Exception e) {
            throw new CrudException("Could not find user : " + user.getEmail(), e);
        }
    }

    @Override
    public void update(ShoppingCart shoppingCart) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.update(shoppingCart);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new CrudException("Can't insert "
                    + shoppingCart.getClass().getName()
                    + " entity " + shoppingCart, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
