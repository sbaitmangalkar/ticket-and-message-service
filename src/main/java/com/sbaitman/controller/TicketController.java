package com.sbaitman.controller;

import com.sbaitman.model.ServiceIssue;
import com.sbaitman.model.ServiceTicket;
import com.sbaitman.service.TicketService;
import com.sbaitman.ticket.proto.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TicketController {
    @Autowired
    private TicketService ticketService;
    @RequestMapping(path = "/tickets/{id}", produces = "application/json")
    public ServiceTicket GetTicketById(@PathVariable String id) {
        return this.ticketService.findById(id);
    }
}
