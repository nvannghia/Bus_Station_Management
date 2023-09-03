/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nvnht.controllers;

import com.nvnht.pojo.User;
import com.nvnht.pojo.UserDetail;
import com.nvnht.service.UserService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author nghia
 */
@Controller
public class UserController {

    @Autowired
    private UserService userDetailsService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register/customer")
    public String registerCustomer(ModelMap model) {
        model.addAttribute("user", new User());
        model.addAttribute("userDetail", new UserDetail());
        return "registercustomer";
    }

    @PostMapping("/register/customer")
    public String registerCustomer(@ModelAttribute(value = "user") @Valid User user,
            BindingResult userErr,
            @ModelAttribute(value = "userDetail") @Valid UserDetail userDetail,
            BindingResult userDetailErr, Model model) {
        if (!this.userDetailsService.getUsers(user.getUsername()).isEmpty()) {
            User userDuplicate = this.userDetailsService.getUsers(user.getUsername()).get(0);
            if (userDuplicate != null) {
                String msgErr = "Tên đăng nhập đã tồn tại";
                

                model.addAttribute("msgErr", msgErr);
                model.addAttribute("username", userDuplicate.getUsername());
                return "registercustomer";
            }
        }
        if (!userErr.hasErrors() && !userDetailErr.hasErrors()) {
            if (this.userDetailsService.addUserCustomer(user, userDetail) == true) {
                return "redirect:/register/customer";
            }
        }
        return "registercustomer";
    }
}
