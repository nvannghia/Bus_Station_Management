/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nvnht.repository.impl;

import com.nvnht.pojo.Buscompanies;
import com.nvnht.pojo.User;
import com.nvnht.repository.BusCompaniesRepository;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Query;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
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
@PropertySource("classpath:configs.properties")
public class BusCompaniesRepositoryImpl implements BusCompaniesRepository {

    @Autowired
    private LocalSessionFactoryBean F;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private Environment env;

    @Autowired
    private SimpleDateFormat SPF;

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
                u.setRetypePassword(pwd); // setRetypePassword() để so sánh với password() ở class User Pojo
                u.setUserRole("ROLE_BUSCOMPANY");
                int id = (Integer) s.save(u);
                if (id != -1) {
//                    b.setActive(Short.valueOf("1"));
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

    @Override
    public Buscompanies getBusCompanyByUserId(int userId) {
        Session s = this.F.getObject().getCurrentSession();
        Query query = s.createQuery("FROM Buscompanies WHERE idUser = :userId")
                .setParameter("userId", userId);
        return (Buscompanies) query.getSingleResult();

    }

    @Override
    public List<Buscompanies> getBuscompaniesPaginate(Map<String, String> params) {
        Session s = this.F.getObject().getCurrentSession();
        Query query = s.createQuery("FROM Buscompanies WHERE active = 1");

        if (params != null) {
            String p = params.get("page");
            if (p != null && !p.isEmpty()) {
                int page = Integer.parseInt(p);
                int pageSize = Integer.parseInt(this.env.getProperty("PAGE_SIZE"));

                query.setMaxResults(pageSize);
                query.setFirstResult((page - 1) * pageSize);
            }
        }

        return query.getResultList();
    }

    @Override
    public int countBusCompanies() {
        Session s = this.F.getObject().getCurrentSession();
        Query query = s.createQuery("SELECT Count(*) From Buscompanies");

        return Integer.parseInt(query.getSingleResult().toString());
    }

    @Override
    public int statsRevenue(Buscompanies bus, String fd, String td) {
        Session s = this.F.getObject().getCurrentSession();
        
        Query query0 = s.createQuery("FROM Ticket WHERE buscompaniesId= :bus AND  createdAt BETWEEN' "+fd+" ' AND ' "+td+" '");
        query0.setParameter("bus", bus);
        if(!query0.getResultList().isEmpty()){ // kiểm tra `fd` và `td` có trong createdAt cua ticket
            Query query = s.createQuery("SELECT sum(fare) FROM Ticket WHERE buscompaniesId= :bus "
                + "AND sold = 1 AND createdAt BETWEEN' "+fd+" ' AND ' "+td+" '");
            query.setParameter("bus", bus);
            return Integer.parseInt(query.getSingleResult().toString());
        }
        return 0;
    }

    @Override
    public Buscompanies getBusCompanyByName(String kw) {
        Session s = this.F.getObject().getCurrentSession();
        Query query = s.createQuery("FROM Buscompanies WHERE name = :kw AND active = 1").setParameter("kw", kw);
        return (Buscompanies) query.getResultList().stream().findFirst().orElse(null);
    }
}
