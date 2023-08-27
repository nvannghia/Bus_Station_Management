/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nvnht.repository;

import com.nvnht.pojo.Location;
import java.util.List;

/**
 *
 * @author nghia
 */
public interface LocationRepository {
    boolean addLocation(Location l);
    List<Location> getLocationesByBusId(int busId);
    Location getLocationById(int id);
    boolean deleteLocation(int id);
    boolean updateLocation(Location l);
}
