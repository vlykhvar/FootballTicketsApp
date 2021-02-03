package com.dev.theater.dao.impl;

import com.dev.theater.dao.MovieDao;
import com.dev.theater.exception.CrudException;
import com.dev.theater.library.Dao;
import com.dev.theater.model.Movie;
import com.dev.theater.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;

@Dao
public class MovieDaoImpl extends DaoImpl<Movie> implements MovieDao {
    @Override
    public List<Movie> getAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Movie", Movie.class).getResultList();
        } catch (Exception e) {
            throw new CrudException("Error getting all movies", e);
        }
    }
}
