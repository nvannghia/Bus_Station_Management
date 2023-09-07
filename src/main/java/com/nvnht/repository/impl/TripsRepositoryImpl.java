/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nvnht.repository.impl;

import com.nvnht.pojo.Buscompanies;
import com.nvnht.pojo.Routes;
import com.nvnht.pojo.Ticket;
import com.nvnht.pojo.Trips;
import com.nvnht.pojo.User;
import com.nvnht.repository.TripsRepository;
import com.nvnht.service.BusCompaniesService;
import com.nvnht.service.RoutesService;
import com.nvnht.service.UserService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Query;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
    @Autowired
    private SimpleDateFormat spf;
    @Autowired
    private RoutesService routesServ;

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
                Routes r = trip.getRoutesId(); // khs chi lay dc moi id
//              Buscompanies busCom = r.getBuscompaniesId();// như vầy nó lỗi, kh lấy đc busCompaniesId
                Buscompanies busCom = this.routesServ.getRouteById(r.getId()).getBuscompaniesId();
                Integer id = (Integer) s.save(trip);
                Trips tripNew = this.getTripById(id);
                if (tripNew != null){
                    for (int i = 1; i < trip.getSeatNumber(); i++) {
                        Ticket ticket = new Ticket();
                        ticket.setSeatNumber(i);
                        ticket.setPayment(Short.valueOf("0"));
                        ticket.setCreatedAt(spf.getCalendar().getInstance().getTime());
                        ticket.setBuscompaniesId(busCom);
                        ticket.setTripsId(tripNew);
                        ticket.setUserId(null);
                        ticket.setSold(Short.valueOf("0"));
                        ticket.setFare(this.routesServ.getRouteById(r.getId()).getFare());
                        s.save(ticket);
                    }
                }
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
