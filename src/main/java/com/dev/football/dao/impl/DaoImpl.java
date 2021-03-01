package com.dev.football.dao.impl;

import com.dev.football.dao.GenericDao;
import com.dev.football.exception.CrudException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

@Repository
public abstract class DaoImpl<T> implements GenericDao<T> {
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
