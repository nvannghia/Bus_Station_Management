/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nvnht.service.impl;

import com.nvnht.pojo.Trips;
import com.nvnht.repository.TripsRepository;
import com.nvnht.service.TripsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author nghia
 */
@Service
public class TripsServiceImpl implements TripsService{

    @Autowired
    private TripsRepository tripRepo;
    @Override
    public List<Trips> getTrips() {
        return this.tripRepo.getTrips();
    }

    @Override
    public boolean addTrip(Trips trip) {
        return this.tripRepo.addTrip(trip);
    }

    @Override
    public Trips getTripById(int id) {
        return this.tripRepo.getTripById(id);
    }

    @Override
    public boolean updateTrip(Trips trip) {
        return this.tripRepo.updateTrip(trip);
    }

    @Override
    public boolean deleteTrip(int id) {
        return this.tripRepo.deleteTrip(id);
    }
    
}
