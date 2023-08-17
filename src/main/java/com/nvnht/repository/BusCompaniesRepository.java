/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nvnht.repository;

import com.nvnht.pojo.Buscompanies;
import com.nvnht.pojo.User;
import java.util.List;

/**
 *
 * @author nghia
 */
public interface BusCompaniesRepository {
    List<Buscompanies> getBusCompanies();
    Buscompanies getBusCompanyById(int id);
    boolean update(int id);
    boolean addBusCompany(User u, Buscompanies b);
}
