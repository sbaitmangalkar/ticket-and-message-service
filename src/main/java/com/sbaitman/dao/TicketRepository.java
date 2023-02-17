package com.sbaitman.dao;

import com.sbaitman.ticket.proto.Ticket;

public interface TicketRepository {
    Ticket findById(String id);
}
