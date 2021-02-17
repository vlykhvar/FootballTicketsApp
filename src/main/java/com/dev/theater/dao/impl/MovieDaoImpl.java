package com.dev.theater.dao.impl;

import com.dev.theater.dao.MovieDao;
import com.dev.theater.exception.CrudException;
import com.dev.theater.model.Movie;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MovieDaoImpl extends DaoImpl<Movie> implements MovieDao {
    @Autowired
    public MovieDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public List<Movie> getAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from Movie", Movie.class).getResultList();
        } catch (Exception e) {
            throw new CrudException("Error getting all movies", e);
        }
    }

    @Override
    public Movie findById(Long movieId) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from Movie "
                    + "where id = :movieId", Movie.class)
                    .setParameter("movieId", movieId)
                    .getSingleResult();
        } catch (Exception e) {
            throw new CrudException("Can't get movie on id " + movieId);
        }
    }
}
