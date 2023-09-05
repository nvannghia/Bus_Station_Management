/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nvnht.controllers;

import com.nvnht.pojo.Buscompanies;
import com.nvnht.pojo.Review;
import com.nvnht.pojo.User;
import com.nvnht.service.BusCompaniesService;
import com.nvnht.service.ReviewService;
import com.nvnht.service.TicketService;
import com.nvnht.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    @Autowired
    private ReviewService reviewServ;
    
    @RequestMapping("/index")
    public String index(Model model){
        model.addAttribute("buscompanies", this.busServ.getBusCompanies());
        return "customerindex";
    }
    
    //Chi tiet nha xe
    @RequestMapping("/bus/detail/{busId}")
    public String busDetail(@PathVariable(value = "busId") int id, Model model){
        Buscompanies bus = this.busServ.getBusCompanyById(id);
        model.addAttribute("busDetail", bus);
        model.addAttribute("tickets", this.ticketServ.getTicketsByBusCompanyId(id));
        model.addAttribute("rating", this.reviewServ.getReviewsByBusCompany(bus));

        //cho danh gia
        model.addAttribute("review", new Review());
        return "busdetail";
    }
    
    //tach ham dung chung 
    public User getUserlogged(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName(); // get username of current user logged
        User user = this.userServ.findUserByUsername(username);
        return user;
    }
    
    //Dat ve xe
    @RequestMapping("/bus/order/{ticketId}")
    public String ticketOrder(@PathVariable(value = "ticketId") int id){
        User user = this.getUserlogged();
        if(user != null){
            if(this.ticketServ.ticketOrder(id, user) == true)
                return "redirect:/customer/ticket/booked";
        }
        return "error";
    }
    
    //ve xe da dat
    @RequestMapping("/ticket/booked")
    public String ticketBooked(Model model){
        User user = this.getUserlogged();
        if(!this.ticketServ.getTicketsByUser(user).isEmpty()){
            model.addAttribute("ticketsbooked", this.ticketServ.getTicketsByUser(user));
        }
        return "ticketbooked";
    }
    
    
    //danh gia
    @PostMapping("/bus/rating/{busId}")
    public String addRating(@ModelAttribute(value = "review") Review review,
                            @PathVariable(value = "busId") int busId,
                            RedirectAttributes redirectAttr){
        User user = this.getUserlogged();
        Buscompanies bus = this.busServ.getBusCompanyById(busId);
        review.setUserId(user);
        review.setBuscompaniesId(bus);
        if(this.reviewServ.addReview(review) == true){
//            return String.format("redirect:customer/bus/detail/%d", busId);
                redirectAttr.addAttribute("busId", busId);
                return "redirect:/customer/bus/detail/{busId}";
//                return "redirect:/customer/index";
        }
        return "error";
    }
}
