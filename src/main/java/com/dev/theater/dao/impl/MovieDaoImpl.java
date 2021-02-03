package com.dev.theater.dao.impl;

import com.dev.theater.dao.MovieDao;
import com.dev.theater.exception.CrudException;
import com.dev.theater.library.Dao;
import com.dev.theater.model.Movie;
import com.dev.theater.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

@Dao
public class MovieDaoImpl implements MovieDao {
    @Override
    public Movie add(Movie movie) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(movie);
            transaction.commit();
            return movie;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new CrudException("Can't insert Movie entity " + movie, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<Movie> getAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Movie", Movie.class).getResultList();
        } catch (Exception e) {
            throw new CrudException("Error getting all movies", e);
        }
    }
}
