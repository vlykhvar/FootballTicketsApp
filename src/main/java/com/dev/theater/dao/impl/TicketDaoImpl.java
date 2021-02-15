package com.dev.theater.dao.impl;

import com.dev.theater.dao.TicketDao;
import com.dev.theater.model.Ticket;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TicketDaoImpl extends DaoImpl<Ticket> implements TicketDao {
    @Autowired
    public TicketDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
}
