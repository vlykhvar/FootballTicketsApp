package com.dev.football.dao.impl;

import com.dev.football.dao.RoleDao;
import com.dev.football.exception.CrudException;
import com.dev.football.model.Role;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDaoImpl extends DaoImpl<Role> implements RoleDao {
    @Autowired
    public RoleDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Role getRoleByName(String roleName) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from Role where roleName = :roleName", Role.class)
                    .setParameter("roleName", roleName)
                    .getSingleResult();
        } catch (Exception e) {
            throw new CrudException("Could not find " + roleName, e);
        }
    }
}
