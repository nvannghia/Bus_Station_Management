/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nvnht.repository;

import com.nvnht.pojo.Ticket;
import java.util.List;

/**
 *
 * @author nghia
 */
public interface TicketRepository {
    List<Ticket> getTicketsByBusCompanyId(int busId);
}
