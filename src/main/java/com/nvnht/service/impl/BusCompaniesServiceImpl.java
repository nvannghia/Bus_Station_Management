/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nvnht.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.nvnht.pojo.Buscompanies;
import com.nvnht.pojo.User;
import com.nvnht.repository.BusCompaniesRepository;
import com.nvnht.service.BusCompaniesService;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    @Autowired
    private Cloudinary cloudinary;
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
        if (!b.getFile().isEmpty()){
            try {
               Map res =  this.cloudinary.uploader()
                        .upload(b.getFile().getBytes(),ObjectUtils.asMap("resource_type","auto"));
               b.setImage(res.get("secure_url").toString());
            } catch (IOException ex) {
                Logger.getLogger(BusCompaniesServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return this.busRepo.addBusCompany(u,b);
    }

    @Override
    public Buscompanies getBusCompanyByUserId(int userId) {
        return this.busRepo.getBusCompanyByUserId(userId);
    }

    @Override
    public List<Buscompanies> getBuscompaniesPaginate(Map<String, String> params) {
        return this.busRepo.getBuscompaniesPaginate(params);
    }

    @Override
    public int countBusCompanies() {
        return this.busRepo.countBusCompanies();
    }
    
}
