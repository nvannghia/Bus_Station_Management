/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nvnht.controllers;

import com.nvnht.pojo.Buscompanies;
import com.nvnht.pojo.Routes;
import com.nvnht.pojo.Trips;
import com.nvnht.pojo.User;
import com.nvnht.service.BusCompaniesService;
import com.nvnht.service.RoutesService;
import com.nvnht.service.TripsService;
import com.nvnht.service.UserService;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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
@RequestMapping("/trips")
public class TripsController {

    @Autowired
    private RoutesService routesServ;
    @Autowired
    private TripsService tripsServ;
    @Autowired
    private SimpleDateFormat SPF;
    @Autowired
    private UserService userServ;
    @Autowired
    private BusCompaniesService busServ;

    public Buscompanies getLogged() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName(); // get username of current user logged
        User u = this.userServ.findUserByUsername(username);
        Buscompanies busCompany = this.busServ.getBusCompanyByUserId(u.getId());
        return busCompany;
    }

    @GetMapping("/add/{routeId}") // tạo chuyến xe cho tuyến xe có id = routeId 
    public String add(Model model, @PathVariable(value = "routeId") int id) {
        //validate lock
        Buscompanies busCompany = this.getLogged();
        if (busCompany.getActive() == 0) {
            return "admincontact";
        }
        
        Routes route = this.routesServ.getRouteById(id);
        Trips trip = new Trips();
        trip.setSeatNumber(null);// mất giá trị default = 0 trong ô input
        trip.setRoutesId(route); // set route để lấy route insert data(bên form truyền hidden)
        model.addAttribute("route", route);
        model.addAttribute("trip", trip);
        return "tripsadd";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute(value = "trip") @Valid Trips trip,
            BindingResult rs,
            Model model) {
        //validate lock
        Buscompanies busCompany = this.getLogged();
        if (busCompany.getActive() == 0) {
            return "admincontact";
        }
        
        if (!rs.hasErrors()) {
            if (this.tripsServ.addTrip(trip) == true) {
                return "redirect:/ticket/list";
            } else {
                return "error";
            }
        }

        model.addAttribute("msgErr", "Vui lòng nhập đúng các ô nhập liệu!");
        model.addAttribute("route", this.routesServ.getRouteById(trip.getRoutesId().getId())); // đổ dữ liệu ngược lại cho view
        return "tripsadd";
    }
}
