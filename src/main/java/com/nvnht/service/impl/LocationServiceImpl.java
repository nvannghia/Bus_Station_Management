/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nvnht.service.impl;

import com.nvnht.pojo.Location;
import com.nvnht.repository.LocationRepository;
import com.nvnht.service.LocationService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author nghia
 */
@Service
public class LocationServiceImpl implements LocationService{
    @Autowired
    private LocationRepository locationRepo;
    @Override
    public boolean addLocation(Location l) {
        return this.locationRepo.addLocation(l);
    }

    @Override
    public List<Location> getLocationes() {
        return this.locationRepo.getLocationes();
    }

    @Override
    public Location getLocationById(int id) {
        return this.locationRepo.getLocationById(id);
    }

    @Override
    public boolean deleteLocation(int id) {
        return this.locationRepo.deleteLocation(id);
    }

    @Override
    public boolean updateLocation(Location l) {
        return this.locationRepo.updateLocation(l);
    }
    
}
