package com.dev.football.dao.impl;

import com.dev.football.dao.StadiumDao;
import com.dev.football.exception.CrudException;
import com.dev.football.model.Stadium;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StadiumDaoImpl extends DaoImpl<Stadium> implements StadiumDao {
    @Autowired
    public StadiumDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public List<Stadium> getAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from Stadium", Stadium.class).getResultList();
        } catch (Exception e) {
            throw new CrudException("Error getting all hall", e);
        }
    }

    @Override
    public Stadium findById(Long cinemaHallId) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from Stadium "
                    + "where id = :cinemaHallId", Stadium.class)
                    .setParameter("cinemaHallId", cinemaHallId)
                    .getSingleResult();
        } catch (Exception e) {
            throw new CrudException("Can't get cinema hall on id " + cinemaHallId);
        }
    }
}
