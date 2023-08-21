/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nvnht.repository.impl;

import com.nvnht.pojo.Buscompanies;
import com.nvnht.pojo.User;
import com.nvnht.repository.BusCompaniesRepository;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author nghia
 */
@Repository
@Transactional
public class BusCompaniesRepositoryImpl implements BusCompaniesRepository {

    @Autowired
    private LocalSessionFactoryBean F;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public List<Buscompanies> getBusCompanies() {
        Session s = this.F.getObject().getCurrentSession();
        Query q = s.createQuery("FROM Buscompanies");
        return q.getResultList();
    }

    @Override
    public Buscompanies getBusCompanyById(int id) {
        Session s = this.F.getObject().getCurrentSession();
        return s.get(Buscompanies.class, id);
    }

    @Override
    public boolean update(int id) {
        Session s = this.F.getObject().getCurrentSession();
        Buscompanies b = this.getBusCompanyById(id);
        int state = b.getActive();
        try {
            if (state != 0) {
                b.setActive(Short.valueOf("0"));
            } else {
                b.setActive(Short.valueOf("1"));
            }
            s.update(b);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean addBusCompany(User u, Buscompanies b) {
        Session s = this.F.getObject().getCurrentSession();
        try {
            if (u.getId() == null && b.getId() == null) {
                String pwd = passwordEncoder.encode(u.getPassword());// hash password
                u.setPassword(pwd);
                u.setRetypePassword(pwd); // setRetypePassword() để so sánh ở class User Pojo
                u.setUserRole("ROLE_BUSCOMPANY");
                int id = (Integer) s.save(u);
                if (id != -1) {
                    b.setActive(Short.valueOf("1"));
                    b.setIdUser(id);
                    s.save(b);
                    return true;
                }
                return false;
            } else {
                return false;
            }
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
