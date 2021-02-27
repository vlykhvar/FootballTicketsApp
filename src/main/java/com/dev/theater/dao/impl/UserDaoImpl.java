package com.dev.theater.dao.impl;

import com.dev.theater.dao.UserDao;
import com.dev.theater.exception.CrudException;
import com.dev.theater.model.User;
import java.util.List;
import java.util.Optional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl extends DaoImpl<User> implements UserDao {
    @Autowired
    public UserDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public List<User> getAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from User", User.class).getResultList();
        } catch (Exception e) {
            throw new CrudException("Error getting all users", e);
        }
    }

    @Override
    public Optional<User> findByEmail(String email) {
        try (Session session = sessionFactory.openSession()) {
            Optional<User> user = session.createQuery("select u from User u"
                    + " join fetch u.roleName where u.email = :email", User.class)
                    .setParameter("email", email)
                    .uniqueResultOptional();
            return user;
        } catch (Exception e) {
            throw new CrudException("Could not find user with email: " + email, e);
        }
    }

    @Override
    public Optional<User> findById(Long userId) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from User "
                    + "where id = :userId", User.class)
                    .setParameter("userId", userId)
                    .uniqueResultOptional();
        } catch (Exception e) {
            throw new CrudException("Can't get user on id " + userId);
        }
    }
}
