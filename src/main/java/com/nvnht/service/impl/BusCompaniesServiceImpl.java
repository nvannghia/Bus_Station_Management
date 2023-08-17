/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nvnht.service.impl;

import com.nvnht.pojo.Buscompanies;
import com.nvnht.pojo.User;
import com.nvnht.repository.BusCompaniesRepository;
import com.nvnht.service.BusCompaniesService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author nghia
 */
@Service
public class BusCompaniesServiceImpl implements BusCompaniesService{
    @Autowired
    private BusCompaniesRepository busRepo;
    @Override
    public List<Buscompanies> getBusCompanies() {
        return this.busRepo.getBusCompanies();
    }

    @Override
    public Buscompanies getBusCompanyById(int id) {
        return this.busRepo.getBusCompanyById(id);
    }

    @Override
    public boolean update(int id) {
        return this.busRepo.update(id);
    }

    @Override
    public boolean addBusCompany(User u, Buscompanies b) {
        return this.busRepo.addBusCompany(u,b);
    }
    
}
