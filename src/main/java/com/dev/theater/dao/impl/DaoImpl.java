package com.dev.theater.dao.impl;

import com.dev.theater.dao.GenericDao;
import com.dev.theater.exception.CrudException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

@Repository
public class DaoImpl<T> implements GenericDao<T> {
    protected final SessionFactory sessionFactory;

    public DaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public T add(T t) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(t);
            transaction.commit();
            return t;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new CrudException("Can't insert " + t.getClass().getName() + " entity " + t, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
