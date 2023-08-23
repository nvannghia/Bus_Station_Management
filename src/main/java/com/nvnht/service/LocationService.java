/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nvnht.service;

import com.nvnht.pojo.Location;
import java.util.List;

/**
 *
 * @author nghia
 */
public interface LocationService {

    boolean addLocation(Location l);

    public List<Location> getLocationes();

    Location getLocationById(int id);

    boolean deleteLocation(int id);

    boolean updateLocation(Location l);

}
