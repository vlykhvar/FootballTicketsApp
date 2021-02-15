package com.dev.theater.dao.impl;

import com.dev.theater.dao.CinemaHallDao;
import com.dev.theater.exception.CrudException;
import com.dev.theater.model.CinemaHall;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CinemaHallDaoImpl extends DaoImpl<CinemaHall> implements CinemaHallDao {
    @Autowired
    public CinemaHallDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public List<CinemaHall> getAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from CinemaHall", CinemaHall.class).getResultList();
        } catch (Exception e) {
            throw new CrudException("Error getting all hall", e);
        }
    }
}
