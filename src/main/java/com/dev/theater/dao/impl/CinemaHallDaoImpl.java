package com.dev.theater.dao.impl;

import com.dev.theater.dao.CinemaHallDao;
import com.dev.theater.exception.CrudException;
import com.dev.theater.library.Dao;
import com.dev.theater.model.CinemaHall;
import com.dev.theater.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;

@Dao
public class CinemaHallDaoImpl extends DaoImpl<CinemaHall> implements CinemaHallDao {
    @Override
    public List<CinemaHall> getAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from CinemaHall", CinemaHall.class).getResultList();
        } catch (Exception e) {
            throw new CrudException("Error getting all hall", e);
        }
    }
}
