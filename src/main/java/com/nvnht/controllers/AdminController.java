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
    @Autowired
    private UserService userDetailsService;

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

        if (!this.userDetailsService.getUsers(u.getUsername()).isEmpty()) { // kiểm tra không rỗng mới lấy dc index 0
            User user = this.userDetailsService.getUsers(u.getUsername()).get(0);
            if (user != null) // kiểm tra đã có username trùng không
            {
                String msgErr = "Tên đăng nhập đã tồn tại";
                model.addAttribute("msgErr", msgErr);
                return "register";
            }
        }
        if (!userErr.hasErrors() && !busErr.hasErrors()) {
            if (this.busService.addBusCompany(u, b) == true) {
                return "redirect:/";
            }
        }

        return "register";
    }

}
