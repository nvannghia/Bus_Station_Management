/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nvnht.controllers;

import com.nvnht.pojo.User;
import com.nvnht.service.BusCompaniesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author nghia
 */
@Controller
public class AdminController {
    @Autowired
    private BusCompaniesService busService;
    
    @GetMapping("/update/{id}")
    public String update(@PathVariable(value = "id") int id){
        this.busService.update(id);
        return "redirect:/";
    }
    
    @GetMapping("/createBusCompanyAccount")
    public String addBusCompany(Model model){
        model.addAttribute("buscompany", new User());
        return "register";
    }
    
    
    
}
