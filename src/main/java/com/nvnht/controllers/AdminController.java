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
import javax.servlet.http.HttpServletRequest;
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
    public String addBusCompany(ModelMap model, HttpServletRequest request) {
        if (request.isUserInRole("ROLE_ADMIN")) {
            model.addAttribute("msgActive", "Đang hoạt động");
        } else {
            model.addAttribute("msgActive", "Chưa hoạt động(Đợi hệ thống xác nhận)");
        }
        User user = new User();
        user.setUsername(null);
        user.setPassword(null);
        model.addAttribute("user", user);
        model.addAttribute("buscompany", new Buscompanies());
        return "register";
    }

    @PostMapping("/createBusCompanyAccount")
    public String add(@ModelAttribute(value = "user") @Valid User user, BindingResult userErr,
            @ModelAttribute(value = "buscompany") @Valid Buscompanies b, BindingResult busErr,
            Model model, HttpServletRequest request) {

        if (!this.userDetailsService.getUsers(user.getUsername()).isEmpty()) {
            User dUser = this.userDetailsService.getUsers(user.getUsername()).get(0);
            if (dUser.getUsername().equalsIgnoreCase(user.getUsername()) == true) {
                model.addAttribute("msgErr", "Tên đăng nhập đã tồn tại");
                return "register";
            }
        }
        if (!userErr.hasErrors() && !busErr.hasErrors()) {
            if (request.isUserInRole("ROLE_ADMIN")) {
                    b.setActive(Short.valueOf("1"));
                } else {
                    b.setActive(Short.valueOf("0"));
                }
            if (this.busService.addBusCompany(user, b) == true) {
                return "redirect:/";
            }
        }

        return "register";
    }

}
