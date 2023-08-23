/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nvnht.controllers;

import com.nvnht.pojo.Buscompanies;
import com.nvnht.service.BusCompaniesService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author nghia
 */
@RestController
public class ApiBusCompanies {
    @Autowired
    private BusCompaniesService busServ;
    @GetMapping("/api/buscompanies")
    public ResponseEntity<List<Buscompanies>> getBusCompanies(){
        List<Buscompanies> buscompanies = this.busServ.getBusCompanies();
        return new ResponseEntity<>(buscompanies,HttpStatus.OK);
    }
}
