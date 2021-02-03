package com.dev.theater.dao.impl;

import com.dev.theater.dao.ShoppingCartDao;
import com.dev.theater.exception.CrudException;
import com.dev.theater.library.Dao;
import com.dev.theater.model.ShoppingCart;
import com.dev.theater.model.User;
import com.dev.theater.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

@Dao
public class ShoppingCartDaoImpl extends DaoImpl<ShoppingCart> implements ShoppingCartDao {
    @Override
    public ShoppingCart getByUser(User user) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from ShoppingCart sc "
                                        + "where sc.user = :user", ShoppingCart.class)
                    .setParameter("user", user)
                    .getSingleResult();
        } catch (Exception e) {
            throw new CrudException("Could not find user : " + user.getEmail(), e);
        }
    }

    @Override
    public void update(ShoppingCart shoppingCart) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
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
