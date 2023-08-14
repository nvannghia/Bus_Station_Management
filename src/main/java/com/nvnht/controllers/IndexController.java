/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nvnht.controllers;


import com.nvnht.service.BusCompaniesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author 84967
 */
@Controller
public class IndexController {
    @Autowired
    private BusCompaniesService busServ;
    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("companies",this.busServ.getBusCompanies());
        return "index";
    }           
}

    

