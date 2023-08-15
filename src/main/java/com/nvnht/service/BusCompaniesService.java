/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nvnht.service;

import com.nvnht.pojo.Buscompanies;
import java.util.List;

/**
 *
 * @author nghia
 */
public interface BusCompaniesService {
    public List<Buscompanies> getBusCompanies();
    Buscompanies getBusCompanyById(int id);
     public boolean update(int id);
}
