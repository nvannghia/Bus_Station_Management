/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nvnht.service.impl;

import com.nvnht.pojo.Buscompanies;
import com.nvnht.pojo.Ticket;
import com.nvnht.pojo.User;
import com.nvnht.repository.TicketRepository;
import com.nvnht.service.TicketService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author nghia
 */
@Service
public class TicketServiceImpl implements TicketService{
    @Autowired
    private TicketRepository ticketRepo;

    @Override
    public List<Ticket> getTicketsByBusCompanyId(int busId) {
        return this.ticketRepo.getTicketsByBusCompanyId(busId);
    }

    @Override
    public Ticket getTicketById(int ticketId) {
        return this.ticketRepo.getTicketById(ticketId);
    }

    @Override
    public boolean ticketOrder(int ticketId, User user) {
        return this.ticketRepo.ticketOrder(ticketId, user);
    }

    @Override
    public List<Ticket> getTicketsByUser(User user) {
        return this.ticketRepo.getTicketsByUser(user);
    }

    @Override
    public List<Ticket> getTicketsByCityName(String departureCity, String destinationCity) {
        return this.ticketRepo.getTicketsByCityName(departureCity, destinationCity);
    }

   
    
}
