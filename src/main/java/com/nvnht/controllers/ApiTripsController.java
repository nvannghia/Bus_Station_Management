/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nvnht.controllers;

import com.nvnht.pojo.Trips;
import com.nvnht.service.TripsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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
@RestController
@RequestMapping("/api")
public class ApiTripsController {
    @Autowired
    private TripsService tripsServ;
    
    //CREATE
    @PostMapping("/trips/add")
    public ResponseEntity<Trips> addTrip(@RequestBody Trips trip){
        if(this.tripsServ.addTrip(trip) == true){
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
    }
    
    //READ
    @GetMapping("/trips/")
    public ResponseEntity<List<Trips>> list(){
        List<Trips> trips = this.tripsServ.getTrips();
        if(trips.isEmpty())
            return new ResponseEntity<List<Trips>>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<List<Trips>>(trips,HttpStatus.OK);
    }
    
    //UPDATE
    @PutMapping("/trips/update/{id}") // UPDATE ALL FEILD
    public ResponseEntity<Trips> updateTrip(@PathVariable("id") int id,
                                            @RequestBody Trips trip){
        Trips currentTrip = this.tripsServ.getTripById(id);
        if(currentTrip == null){
             return new ResponseEntity<Trips>(HttpStatus.NOT_FOUND);
        }
         //KIEM TRA CAC TRUONG KHAC RONG TRUOC
        currentTrip.setDepartureDate(trip.getDepartureDate());
        currentTrip.setDepartureTime(trip.getDepartureTime());
        currentTrip.setLicensePlates(trip.getLicensePlates());
        currentTrip.setSeatNumber(trip.getSeatNumber());
        currentTrip.setRoutesId(trip.getRoutesId());
        this.tripsServ.updateTrip(currentTrip);
        return new ResponseEntity<Trips>(currentTrip,HttpStatus.OK);
    }
    
    @DeleteMapping("/trips/delete/{id}")
    public ResponseEntity<Trips> deleteTrip(@PathVariable("id") int id){
       if(this.tripsServ.getTripById(id) == null){
           return new ResponseEntity<Trips>(HttpStatus.NOT_FOUND);
       }
       this.tripsServ.deleteTrip(id);
       return new ResponseEntity<Trips>(HttpStatus.NO_CONTENT);
    }
}
