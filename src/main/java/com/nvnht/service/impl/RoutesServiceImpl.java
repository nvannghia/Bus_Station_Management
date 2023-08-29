/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nvnht.service.impl;

import com.nvnht.pojo.Routes;
import com.nvnht.repository.RoutesRepository;
import com.nvnht.service.RoutesService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author nghia
 */
@Service
public class RoutesServiceImpl implements RoutesService{
    @Autowired
    private RoutesRepository routesRepo;

    @Override
    public List<Routes> getRoutes() {
        return this.routesRepo.getRoutes();
    }

    @Override
    public boolean addRoute(Routes r) {
        return this.routesRepo.addRoute(r);
    }

    @Override
    public Routes getRouteById(int id) {
        return this.routesRepo.getRouteById(id);
    }

    @Override
    public boolean updateRoute(Routes r) {
        return this.routesRepo.updateRoute(r);
    }

    @Override
    public boolean deleteRoute(int id) {
        return this.routesRepo.deleteRoute(id);
    }

    @Override
    public List<Routes> getRoutesByBusId(int busId) {
        return this.routesRepo.getRoutesByBusId(busId);
    }
    
}
