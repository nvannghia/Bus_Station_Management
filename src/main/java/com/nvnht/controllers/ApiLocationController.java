/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nvnht.controllers;

import com.nvnht.pojo.Location;
import com.nvnht.service.BusCompaniesService;
import com.nvnht.service.LocationService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author nghia
 */
//@Controller
@RestController
@RequestMapping("/api")
public class ApiLocationController {

    @Autowired
    private LocationService locationServ;
//    @Autowired
//    private BusCompaniesService busComServ;
//    @GetMapping("/location/add")
//    public String add(Model model){
//        model.addAttribute("location", new Location());
//        model.addAttribute("buscompanies", this.busComServ.getBusCompanies());
//        return "locationregister";
//    }

//    @PostMapping("/location/add")
//    public String addLaction(@ModelAttribute(value = "location") Location l){
//        if(this.locationServ.addLocation(l)== true)
//            return "locationregister";
//        
//        return "error";
//    }
    //////////------------ C R U D----------------------
    //CREATE
    @PostMapping("/location/add")
    public ResponseEntity<Location> addLocation(@RequestBody Location l) {
        if (this.locationServ.addLocation(l) == true) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
    }

    //READ
    @GetMapping("/location/")
    @CrossOrigin
    public ResponseEntity<List<Location>> list() {
        List<Location> locationes = this.locationServ.getLocationes();
        if (locationes.isEmpty()) {
            return new ResponseEntity<List<Location>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Location>>(locationes, HttpStatus.OK);
    }

    //UPDATE
    @PatchMapping("/location/update/{id}")
    public ResponseEntity<Location> updateLocation(@PathVariable("id") int id,
            @RequestBody Location l) {
        Location currentLocation = this.locationServ.getLocationById(id);
        if (currentLocation == null) {
            return new ResponseEntity<Location>(HttpStatus.NOT_FOUND);
        }

        currentLocation.setCityName(l.getCityName());
        currentLocation.setDistrictName(l.getDistrictName());
        currentLocation.setStreetName(l.getStreetName());
        this.locationServ.updateLocation(currentLocation);
        return new ResponseEntity<Location>(currentLocation, HttpStatus.OK);
    }

    //DELETE
    @DeleteMapping("/location/delete/{id}")
    public ResponseEntity<Location> deleteLocation(@PathVariable("id") int id) {
        if (this.locationServ.getLocationById(id) == null) {
            return new ResponseEntity<Location>(HttpStatus.NOT_FOUND);
        }
        this.locationServ.deleteLocation(id);
        return new ResponseEntity<Location>(HttpStatus.NO_CONTENT);
    }

}
