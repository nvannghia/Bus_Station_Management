/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nvnht.repository.impl;

import com.nvnht.pojo.Trips;
import com.nvnht.repository.TripsRepository;
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
public class TripsRepositoryImpl implements TripsRepository {

    @Autowired
    private LocalSessionFactoryBean F;

    @Override
    public List<Trips> getTrips() {
        Session s = this.F.getObject().getCurrentSession();
        Query q = s.createQuery("FROM Trips");
        return q.getResultList();
    }

    @Override
    public boolean addTrip(Trips trip) {
        Session s = this.F.getObject().getCurrentSession();
        try {
            if (trip.getId() == null) {
                s.save(trip);
            }
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public Trips getTripById(int id) {
        Session s = this.F.getObject().getCurrentSession();
        return s.get(Trips.class, id);
    }

    @Override
    public boolean updateTrip(Trips trip) {
        Session s = this.F.getObject().getCurrentSession();
        try {
            s.update(trip);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteTrip(int id) {
        Session s = this.F.getObject().getCurrentSession();
        Trips trip = this.getTripById(id);
        try {
            s.delete(trip);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

}
