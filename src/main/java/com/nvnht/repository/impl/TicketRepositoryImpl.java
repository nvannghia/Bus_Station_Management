/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nvnht.repository.impl;

import com.nvnht.pojo.Ticket;
import com.nvnht.pojo.User;
import com.nvnht.repository.TicketRepository;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author nghia
 */
@Repository
@Transactional
public class TicketRepositoryImpl implements TicketRepository {

    @Autowired
    private LocalSessionFactoryBean F;

    @Override
    public List<Ticket> getTicketsByBusCompanyId(int busId) {
        Session s = this.F.getObject().getCurrentSession();
        Query query = s.createQuery("FROM Ticket WHERE buscompaniesId.id = :busId")
                .setParameter("busId", busId);
        return query.getResultList();
    }

    @Override
    public Ticket getTicketById(int ticketId) {
        Session s = this.F.getObject().getCurrentSession();
        Query q = s.createQuery("FROM Ticket WHERE id= :id").setParameter("id", ticketId);
        return (Ticket)q.getSingleResult();
    }

    @Override
    public boolean ticketOrder(int ticketId, User user) {
        Session s = this.F.getObject().getCurrentSession();
        Ticket ticket = this.getTicketById(ticketId);
        try {
            if (ticket != null) {
                ticket.setUserId(user);
                ticket.setSold(Short.valueOf("1"));
                s.update(ticket);
                return true;
            }
            return false;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

}
