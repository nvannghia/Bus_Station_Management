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
import java.text.SimpleDateFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author nghia
 */
@Controller
@RequestMapping("/buscompany")
public class BuscompanyController {

    @Autowired
    private BusCompaniesService busServ;
    @Autowired
    private UserService userServ;
    @Autowired
    private SimpleDateFormat SPF;

    @RequestMapping("/statistical")
    public String statisticalBus(Model model) {
        return "statisticalBus";
    }

    @RequestMapping("/statistical/revenue")
    public String statisticalBus(Model model, @RequestParam("fd") String fd, @RequestParam("td") String td) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName(); // get username of current user logged
        User u = this.userServ.findUserByUsername(username);
        Buscompanies bus = this.busServ.getBusCompanyByUserId(u.getId());
        
        model.addAttribute("fd", fd);
        model.addAttribute("td", td);
        
        if (this.busServ.statsRevenue(bus, fd, td) != 0) {
            model.addAttribute("sum", this.busServ.statsRevenue(bus, fd, td));
        } else {
            model.addAttribute("msg", "Chưa có doanh thu trong từ ngày");
        }

        return "statisticalBus";

    }
}
