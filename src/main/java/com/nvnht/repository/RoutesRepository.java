/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nvnht.repository;

import com.nvnht.pojo.Routes;
import java.util.List;

/**
 *
 * @author nghia
 */
public interface RoutesRepository {

    List<Routes> getRoutes();

    List<Routes> getRoutesByBusId(int busId);

    boolean addRoute(Routes r);

    Routes getRouteById(int id);

    boolean updateRoute(Routes r);

    boolean deleteRoute(int id);
}
