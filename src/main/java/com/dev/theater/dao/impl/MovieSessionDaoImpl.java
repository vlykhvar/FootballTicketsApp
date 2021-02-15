package com.dev.theater.dao.impl;

import com.dev.theater.dao.MovieSessionDao;
import com.dev.theater.exception.CrudException;
import com.dev.theater.model.MovieSession;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MovieSessionDaoImpl extends DaoImpl<MovieSession> implements MovieSessionDao {
    @Autowired
    public MovieSessionDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public List<MovieSession> findAvailableSessions(Long movieId, LocalDate date) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from MovieSession "
                    + "where id = :movieId and DATE_FORMAT(showTime,'%Y-%m-%d') "
                    + "= :date", MovieSession.class)
                    .setParameter("movieId", movieId)
                    .setParameter("date", date.format(DateTimeFormatter.ISO_DATE))
                    .getResultList();
        } catch (Exception e) {
            throw new CrudException("Can't get session on id " + movieId + " in " + date);
        }
    }
}
