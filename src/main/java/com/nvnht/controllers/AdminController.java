/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nvnht.controllers;

import com.nvnht.pojo.Buscompanies;
import com.nvnht.pojo.User;
import com.nvnht.service.BusCompaniesService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author nghia
 */
@Controller
public class AdminController {

    @Autowired
    private BusCompaniesService busService;

    @GetMapping("/update/{id}")
    public String update(@PathVariable(value = "id") int id) {
        if (this.busService.update(id) == true) {
            return "redirect:/";
        }
        return "error";
    }

    @GetMapping("/createBusCompanyAccount")
    public String addBusCompany(ModelMap model) {
        model.addAttribute("user", new User());
        model.addAttribute("buscompany", new Buscompanies());
        return "register";
    }

    @PostMapping("/createBusCompanyAccount")
    public String add(@ModelAttribute(value = "user") @Valid User u, BindingResult userErr,
            @ModelAttribute(value = "buscompany") @Valid Buscompanies b, BindingResult busErr, Model model) {
            
        if(!userErr.hasErrors() && !busErr.hasErrors())
            if (this.busService.addBusCompany(u, b) == true) {
                return "redirect:/";
            }
            
        return "register";
    }

}
