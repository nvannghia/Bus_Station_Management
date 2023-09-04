/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nvnht.controllers;

import com.nvnht.pojo.User;
import com.nvnht.service.BusCompaniesService;
import com.nvnht.service.TicketService;
import com.nvnht.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author nghia
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private BusCompaniesService busServ;
    @Autowired
    private TicketService ticketServ;
    @Autowired
    private UserService userServ;
    
    @RequestMapping("/index")
    public String index(Model model){
        model.addAttribute("buscompanies", this.busServ.getBusCompanies());
        return "customerindex";
    }
    
    //Chi tiet nha xe
    @RequestMapping("/bus/detail/{busId}")
    public String busDetail(@PathVariable(value = "busId") int id, Model model){
        model.addAttribute("busDetail",this.busServ.getBusCompanyById(id));
        model.addAttribute("tickets", this.ticketServ.getTicketsByBusCompanyId(id));
        return "busdetail";
    }
    
    //Dat ve xe
    @RequestMapping("/bus/order/{ticketId}")
    public String ticketOrder(@PathVariable(value = "ticketId") int id){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName(); // get username of current user logged
        User user = this.userServ.findUserByUsername(username);
        if(user != null){
            if(this.ticketServ.ticketOrder(id, user) == true)
                return "customerindex";
        }
        return "error";
    }
}
