/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nvnht.repository.impl;

import com.nvnht.pojo.Location;
import com.nvnht.repository.LocationRepository;
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
public class LocationRepositoryImpl implements LocationRepository {

    @Autowired
    private LocalSessionFactoryBean F;

    @Override
    public boolean addLocation(Location l) {
        Session s = this.F.getObject().getCurrentSession();
        try {
            if (l.getId() == null) {
                s.save(l);
            }
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Location> getLocationes() {
        Session s = this.F.getObject().getCurrentSession();
        Query q = s.createQuery("FROM Location");
        return q.getResultList();
    }

    @Override
    public Location getLocationById(int id) {
        Session s = this.F.getObject().getCurrentSession();
        return s.get(Location.class, id);
    }

    @Override
    public boolean deleteLocation(int id) {
        Session s = this.F.getObject().getCurrentSession();
        Location l = this.getLocationById(id);
        try {
            s.delete(l);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateLocation(Location l) {
        Session s = this.F.getObject().getCurrentSession();
        try {
            s.update(l);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

}
