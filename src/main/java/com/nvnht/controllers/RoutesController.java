/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nvnht.controllers;

import com.nvnht.pojo.Buscompanies;
import com.nvnht.pojo.Routes;
import com.nvnht.pojo.User;
import com.nvnht.service.BusCompaniesService;
import com.nvnht.service.LocationService;
import com.nvnht.service.RoutesService;
import com.nvnht.service.UserService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.RouteMatcher;
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
@RequestMapping("/routes")
public class RoutesController {

    @Autowired
    private UserService userServ;
    @Autowired
    private BusCompaniesService busServ;
    @Autowired
    private RoutesService routesServ;
    @Autowired
    private LocationService locateServ;

    public Buscompanies getLogged() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName(); // get username of current user logged
        User u = this.userServ.findUserByUsername(username);
        Buscompanies busCompany = this.busServ.getBusCompanyByUserId(u.getId());
        return busCompany;
    }

    @RequestMapping("/list")
    public String list(Model model) {
        Buscompanies busCompany = this.getLogged();
        model.addAttribute("routes", this.routesServ.getRoutesByBusId(busCompany.getId()));
        return "routeslist";
    }

    @ModelAttribute
    public void commonAttr(Model model) {
        Buscompanies busCompany = this.getLogged();
        model.addAttribute("locationes", this.locateServ.getLocationesByBusId(busCompany.getId()));
    }

    @GetMapping("/add")
    public String add(Model model) {
        Routes route = new Routes();
        route.setFare(null); // mục đích là để nó k hiện props mặc định = 0 trong ô input bên form
        model.addAttribute("route", route);
        return "routesadd";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute(value = "route") @Valid Routes route,
            BindingResult rs,
            Model model) {
        if (route.getDepartureId().getId() == route.getDestinationId().getId()) {
            model.addAttribute("errMsg", "Điểm xuất phát và điểm đến không được trùng nhau!");
            return "routesadd";
        }
        if (!rs.hasErrors()) {
            Buscompanies busCompany = this.getLogged();
            route.setBuscompaniesId(busCompany);
            if (this.routesServ.addRoute(route) == true) {
                return "redirect:/routes/list";
            }
        }
        return "routesadd";
    }

    @GetMapping("/update/{id}")
    public String update(Model model, @PathVariable(value = "id") int id) {
        Routes route = this.routesServ.getRouteById(id);
        model.addAttribute("route", route);
        return "routesupdate";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute(value = "route") Routes route, Model model) {
        if (route.getDepartureId().getId() == route.getDestinationId().getId()) {
            model.addAttribute("errMsg", "Điểm xuất phát và điểm đến không được trùng nhau!");
            return "routesupdate";
        }
        if (this.routesServ.updateRoute(route) == true) {
            return "redirect:/routes/list";
        }

        return "errors";
    }

//    @GetMapping("/delete/{id}")
//    public String delete(@PathVariable(value = "id") int id) {
//        if (this.routesServ.deleteRoute(id) == true) {
//            return "redirect:/routes/list";
//        }
//        return "errors";
//    }
}
