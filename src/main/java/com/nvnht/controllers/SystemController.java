/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nvnht.controllers;

import com.nvnht.pojo.Buscompanies;
import com.nvnht.pojo.User;
import com.nvnht.pojo.UserDetail;
import com.nvnht.service.BusCompaniesService;
import com.nvnht.service.UserService;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author nghia
 */
@Controller
public class SystemController {
    
    @RequestMapping("/who")
    public String who(HttpServletRequest request){
        if(request.isUserInRole("ROLE_ADMIN"))
            return "redirect:/";
        else if(request.isUserInRole("ROLE_BUSCOMPANY"))
            return "redirect:/location/list";
        else
            return "redirect:/customer/index";
    }
    
   
    
   
}
