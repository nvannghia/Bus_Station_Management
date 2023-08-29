/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nvnht.repository;

import com.nvnht.pojo.Trips;
import java.util.List;

/**
 *
 * @author nghia
 */
public interface TripsRepository {

    List<Trips> getTrips();
    
    boolean addTrip(Trips trip);

    Trips getTripById(int id);

    boolean updateTrip(Trips trip);

    boolean deleteTrip(int id);
}
