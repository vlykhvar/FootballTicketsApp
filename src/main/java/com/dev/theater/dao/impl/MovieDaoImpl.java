package com.dev.theater.dao.impl;

import com.dev.theater.dao.MovieDao;
import com.dev.theater.library.Dao;
import com.dev.theater.model.Movie;
import com.dev.theater.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Dao
public class MovieDaoImpl implements MovieDao {

    @Override
    public Movie add(Movie movie) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Long itemId = (Long) session.save(movie);
            transaction.commit();
            movie.setId(itemId);
            return movie;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Can't insert Movie entity", e);
        } finally {
        session.close();
        }
    }

    @Override
    public List<Movie> getAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            CriteriaQuery<Movie> criteriaQuery = session.getCriteriaBuilder()
                    .createQuery(Movie.class);
            criteriaQuery.from(Movie.class);
            return session.createQuery(criteriaQuery).getResultList();
       } catch (Exception e){
            throw new RuntimeException("Error getting all movies", e);
        }
    }
}

