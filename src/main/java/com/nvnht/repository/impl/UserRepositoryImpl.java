/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nvnht.repository.impl;

import com.nvnht.pojo.User;
import com.nvnht.pojo.UserDetail;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import com.nvnht.repository.UserRepository;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author nghia
 */
@Repository
@Transactional
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private LocalSessionFactoryBean factory;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public List<User> getUsers(String username) {
        Session session = this.factory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root root = query.from(User.class);
        query = query.select(root);

        if (!username.isEmpty()) {
            Predicate p = builder.equal(root.get("username").as(String.class), username.trim());
            query = query.where(p);
        }
        Query q = session.createQuery(query);
        return q.getResultList();
    }

    @Override
    public User findUserByUsername(String username) {
        Session s = this.factory.getObject().getCurrentSession();
        Query query = s.createQuery("FROM User WHERE username = :username")
                .setParameter("username", username);
        return (User) query.getSingleResult();
    }

    @Override
    public boolean addUserCustomer(User user, UserDetail userDetail) {
        Session s = this.factory.getObject().getCurrentSession();
        try {
            if (user.getId() == null && userDetail.getId() == null) {
                String pwd = passwordEncoder.encode(user.getPassword());// hash password
                user.setPassword(pwd);
                user.setRetypePassword(pwd); // setRetypePassword() để so sánh với password() ở class User Pojo
                user.setUserRole("ROLE_CUSTOMER");
                int id = (Integer) s.save(user);
                if(id > 0){
                    userDetail.setUserId(id);
                    s.save(userDetail);
                    return true;
                } else{
                    return false;
                }
            } else{
                return false;
            }
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

}
