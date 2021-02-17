package com.dev.theater.dao.impl;

import com.dev.theater.dao.MovieSessionDao;
import com.dev.theater.exception.CrudException;
import com.dev.theater.model.MovieSession;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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

    public MovieSession update(MovieSession movieSession) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.update(movieSession);
            transaction.commit();
            return movieSession;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new CrudException("Can't update moviesession: "
                    + movieSession, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public boolean delete(Long id) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            MovieSession movieSession = session.load(MovieSession.class, id);
            session.remove(movieSession);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new CrudException("Can't delete moviesession by id: "
                    + id, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public Optional<MovieSession> getById(Long movieSessionId) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from MovieSession"
                    + "where id = :movieSessionId", MovieSession.class)
                    .setParameter("movieSessionId", movieSessionId)
                    .uniqueResultOptional();
        } catch (Exception e) {
            throw new CrudException("Can't get movie session on id " + movieSessionId);
        }
    }
}
