/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nvnht.repository.impl;

import com.nvnht.pojo.Buscompanies;
import com.nvnht.pojo.Review;
import com.nvnht.repository.BusCompaniesRepository;
import com.nvnht.repository.ReviewRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;

/**
 *
 * @author nghia
 */
@Repository
@Transactional
public class ReviewRepositoryImpl implements ReviewRepository{
    @Autowired
    private LocalSessionFactoryBean F;
    @Override
    public boolean addReview(Review review) {
        Session s = this.F.getObject().getCurrentSession();
        try {
            s.save(review);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Review> getReviewsByBusCompany(Buscompanies b) {
        Session s = this.F.getObject().getCurrentSession();
        Query query = s.createQuery("FROM Review WHERE buscompaniesId= :b")
                        .setParameter("b", b);
        return query.getResultList();
    }

    @Override
    public Double getNumberStarByBus(Buscompanies bus) {
        Session s = this.F.getObject().getCurrentSession();
        
        Query query = s.createQuery("SELECT AVG(star) FROM Review WHERE buscompaniesId= :bus")
                        .setParameter("bus", bus);
        Number result = (Number) query.getSingleResult();
        return Optional.ofNullable(result).orElse(0).doubleValue();
    }
    
}
