package com.dev.football.dao.impl;

import com.dev.football.dao.GameDao;
import com.dev.football.exception.CrudException;
import com.dev.football.model.Game;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class GameDaoImpl extends DaoImpl<Game> implements GameDao {
    @Autowired
    public GameDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public List<Game> getAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from Game", Game.class).getResultList();
        } catch (Exception e) {
            throw new CrudException("Error getting all movies", e);
        }
    }

    @Override
    public Game findById(Long gameId) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from Game "
                    + "where id = :gameId", Game.class)
                    .setParameter("gameId", gameId)
                    .getSingleResult();
        } catch (Exception e) {
            throw new CrudException("Can't get movie on id " + gameId);
        }
    }
}
