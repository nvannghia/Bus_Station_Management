/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nvnht.repository;

import com.nvnht.pojo.Buscompanies;
import com.nvnht.pojo.User;
import java.util.List;
import java.util.Map;

/**
 *
 * @author nghia
 */
public interface BusCompaniesRepository {

    List<Buscompanies> getBusCompanies();

    Buscompanies getBusCompanyById(int id);

    Buscompanies getBusCompanyByUserId(int userId);

    boolean update(int id);

    boolean addBusCompany(User u, Buscompanies b);

    List<Buscompanies> getBuscompaniesPaginate(Map<String, String> params);

    int countBusCompanies();
    
    int statsRevenue(Buscompanies bus,String fd, String td);
    
    Buscompanies getBusCompanyByName(String kw);

}
