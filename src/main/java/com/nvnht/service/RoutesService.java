/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nvnht.service;

import com.nvnht.pojo.Routes;
import java.util.List;

/**
 *
 * @author nghia
 */
public interface RoutesService {

    List<Routes> getRoutes();

    boolean addRoute(Routes r);

    public Routes getRouteById(int id);

    boolean updateRoute(Routes r);

    boolean deleteRoute(int id);
}
