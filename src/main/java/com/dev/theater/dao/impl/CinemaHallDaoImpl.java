package com.dev.theater.dao.impl;

import com.dev.theater.dao.CinemaHallDao;
import com.dev.theater.exception.CrudException;
import com.dev.theater.library.Dao;
import com.dev.theater.model.CinemaHall;
import com.dev.theater.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

@Dao
public class CinemaHallDaoImpl implements CinemaHallDao {
    @Override
    public CinemaHall add(CinemaHall cinemaHall) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(cinemaHall);
            transaction.commit();
            return cinemaHall;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new CrudException("Can't insert Cinema Hall entity " + cinemaHall, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<CinemaHall> getAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from CinemaHall", CinemaHall.class).getResultList();
        } catch (Exception e) {
            throw new CrudException("Error getting all hall", e);
        }
    }
}
