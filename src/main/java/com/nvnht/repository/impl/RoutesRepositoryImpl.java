/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nvnht.repository.impl;

import com.nvnht.pojo.Routes;
import com.nvnht.repository.RoutesRepository;
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
public class RoutesRepositoryImpl implements RoutesRepository{

    @Autowired
    private LocalSessionFactoryBean F;
    @Override
    public List<Routes> getRoutes() {
        Session s = this.F.getObject().getCurrentSession();
        Query q = s.createQuery("FROM Routes");
        return q.getResultList();
    }

    @Override
    public boolean addRoute(Routes r) {
        Session s = this.F.getObject().getCurrentSession();
        try {
            if (r.getId() == null) {
                s.save(r);
            }
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public Routes getRouteById(int id) {
       Session s = this.F.getObject().getCurrentSession();
       return s.get(Routes.class, id);
    }

    @Override
    public boolean updateRoute(Routes r) {
        Session s = this.F.getObject().getCurrentSession();
        try {
            s.update(r);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteRoute(int id) {
        Session s = this.F.getObject().getCurrentSession();
        Routes r = this.getRouteById(id);
        try {
            s.delete(r);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Routes> getRoutesByBusId(int busId) {
        Session s = this.F.getObject().getCurrentSession();
        Query query = s.createQuery("FROM Routes WHERE buscompaniesId.id = :busId")
                        .setParameter("busId", busId);
        return query.getResultList();
    }
    
}
