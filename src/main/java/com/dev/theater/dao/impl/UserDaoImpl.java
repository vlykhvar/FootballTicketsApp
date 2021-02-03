package com.dev.theater.dao.impl;

import com.dev.theater.dao.UserDao;
import com.dev.theater.exception.CrudException;
import com.dev.theater.library.Dao;
import com.dev.theater.model.User;
import com.dev.theater.util.HibernateUtil;
import java.util.List;
import java.util.Optional;
import org.hibernate.Session;

@Dao
public class UserDaoImpl extends DaoImpl<User> implements UserDao {
    @Override
    public List<User> getAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from User", User.class).getResultList();
        } catch (Exception e) {
            throw new CrudException("Error getting all users", e);
        }
    }

    @Override
    public Optional<User> findByEmail(String email) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from User where email = :email", User.class)
                    .setParameter("email", email)
                    .uniqueResultOptional();
        } catch (Exception e) {
            throw new CrudException("Could not find user with email: " + email, e);
        }
    }
}
