/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nvnht.controllers;

import com.nvnht.pojo.Buscompanies;
import com.nvnht.pojo.User;
import com.nvnht.service.BusCompaniesService;
import com.nvnht.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author nghia
 */
@Controller
public class SystemController {
    
    private static User u;
    private static Buscompanies busCompany;
    @Autowired
    private static UserService userServ;
    @Autowired
    private static BusCompaniesService busServ;
    
    @RequestMapping("/who")
    public String who(){
        return "who";
    }
    
//   public static Buscompanies getLogged(){
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        String username = auth.getName(); // get username of current user logged
//        u = userServ.findUserByUsername(username);
//        busCompany = busServ.getBusCompanyByUserId(u.getId());
//        return busCompany;
//   }
}
