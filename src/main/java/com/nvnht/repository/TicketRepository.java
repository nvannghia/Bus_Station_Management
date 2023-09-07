/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nvnht.repository;

import com.nvnht.pojo.Ticket;
import com.nvnht.pojo.User;
import java.util.List;

/**
 *
 * @author nghia
 */
public interface TicketRepository {
    List<Ticket> getTicketsByBusCompanyId(int busId);
    Ticket getTicketById(int ticketId);
    boolean ticketOrder(int ticketId, User user);
    List<Ticket> getTicketsByUser(User user);
    List<Ticket> getTicketsByCityName(String departureCity, String destinationCity);
}
