/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nvnht.controllers;

import com.nvnht.pojo.Buscompanies;
import com.nvnht.pojo.Location;
import com.nvnht.pojo.User;
import com.nvnht.service.BusCompaniesService;
import com.nvnht.service.LocationService;
import com.nvnht.service.UserService;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author nghia
 */
@Controller
@RequestMapping("/location")
public class LocationController {

    @Autowired
    private UserService userServ;
    @Autowired
    private BusCompaniesService busServ;
    @Autowired
    private LocationService locateServ;

    @RequestMapping("/list")
    public String getLocationes(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName(); // get username of current user logged
        User u = this.userServ.findUserByUsername(username);
        Buscompanies busCompany = this.busServ.getBusCompanyByUserId(u.getId());
        model.addAttribute("locationes", this.locateServ.getLocationesByBusId(busCompany.getId()));
        return "locationlist";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("location", new Location());
        return "addlocation";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute(value = "location") @Valid Location locate,
            BindingResult rs) {
        if (!rs.hasErrors()) {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            String username = auth.getName(); // get username of current user logged
            User u = this.userServ.findUserByUsername(username);
            Buscompanies busCompany = this.busServ.getBusCompanyByUserId(u.getId());

            locate.setBuscompaniesId(busCompany);
            if (this.locateServ.addLocation(locate) == true) {
                return "redirect:/location/list";
            }
        }
        return "addlocation";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        if (this.locateServ.deleteLocation(id) == true) {
            return "redirect:/location/list";
        }
        return "error";
    }

    @GetMapping("/update/{id}")
    public String update(Model model, @PathVariable("id") int id) {
        model.addAttribute("location", this.locateServ.getLocationById(id));
        return "locationupdate";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute(value = "location") @Valid Location locate,
            BindingResult rs) {
        if(!rs.hasErrors()){
            if (this.locateServ.updateLocation(locate) == true) {
               return "redirect:/location/list";
            }   
        }
        
        return "addlocation";
    }
}
