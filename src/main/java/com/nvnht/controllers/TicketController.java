/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nvnht.controllers;

import com.nvnht.pojo.Buscompanies;
import com.nvnht.pojo.User;
import com.nvnht.service.BusCompaniesService;
import com.nvnht.service.TicketService;
import com.nvnht.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author nghia
 */
@Controller
@RequestMapping("/ticket")
public class TicketController {
    @Autowired
    private UserService userServ;
    @Autowired
    private BusCompaniesService busServ;
    @Autowired
    private TicketService tickerServ;
    
    @RequestMapping("/list")
    public String list(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName(); // get username of current user logged
        User u = this.userServ.findUserByUsername(username);
        Buscompanies busCompany = this.busServ.getBusCompanyByUserId(u.getId());
        String busName = busCompany.getName();
        model.addAttribute("tickets",this.tickerServ.getTicketsByBusCompanyId(busCompany.getId()));
        model.addAttribute("busName", busName);
        return "ticketlist";
    }
}
