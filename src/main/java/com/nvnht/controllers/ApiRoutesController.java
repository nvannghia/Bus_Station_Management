/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nvnht.controllers;

import com.nvnht.pojo.Routes;
import com.nvnht.service.RoutesService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author nghia
 */
@RestController
@RequestMapping("/api")
public class ApiRoutesController {
    @Autowired
    private RoutesService routesServ;
    
    
    //CREATE
    @PostMapping("/routes/add")
    public ResponseEntity<Routes> addRoute(@RequestBody Routes r){
        if(this.routesServ.addRoute(r) == true){
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
    }
    
    
    //READ
    @GetMapping("/routes/")
    public ResponseEntity<List<Routes>> list(){
        List<Routes> routes = this.routesServ.getRoutes();
        if(routes.isEmpty())
            return new ResponseEntity<List<Routes>>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<List<Routes>>(routes,HttpStatus.OK);
    }
    
    
    //UPDATE
    @PatchMapping("/routes/update/{id}")
    public ResponseEntity<Routes> updateRoute(@PathVariable("id") int id,
                                            @RequestBody Routes r){
        Routes currentRoute = this.routesServ.getRouteById(id);
        if(currentRoute == null){
             return new ResponseEntity<Routes>(HttpStatus.NOT_FOUND);
        }
        
        currentRoute.setFare(r.getFare());
        currentRoute.setDepartureId(r.getDepartureId());
        currentRoute.setDestinationId(r.getDestinationId());
        this.routesServ.updateRoute(currentRoute);
        return new ResponseEntity<Routes>(currentRoute,HttpStatus.OK);
    }
    
    @DeleteMapping("/routes/delete/{id}")
    public ResponseEntity<Routes> deleteRoute(@PathVariable("id") int id){
        if(this.routesServ.getRouteById(id)==null){
            return new ResponseEntity<Routes>(HttpStatus.NOT_FOUND);
        }
        this.routesServ.deleteRoute(id);
        return new ResponseEntity<Routes>(HttpStatus.NO_CONTENT);
    }
    
}
