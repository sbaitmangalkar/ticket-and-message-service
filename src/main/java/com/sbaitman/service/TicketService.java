package com.sbaitman.service;

import com.sbaitman.dao.TicketRepository;
import com.sbaitman.model.ServiceIssue;
import com.sbaitman.model.ServiceTicket;
import com.sbaitman.ticket.proto.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TicketService {
    @Autowired
    private TicketRepository ticketRepository;
    public ServiceTicket findById(String id) {
        Ticket ticket = this.ticketRepository.findById(id);
        if(ticket == null) {
            return new ServiceTicket("NA", "NA", 0L, new ArrayList<>());
        }
        List<ServiceIssue> serviceIssues = null;
        if(ticket.getIssuesList() != null && ticket.getIssuesList().size() > 0) {
            serviceIssues = ticket.getIssuesList().stream()
                    .map(i -> new ServiceIssue(i.getId(), i.getAssignee(), i.getDescription(), i.getPriority().name()))
                    .collect(Collectors.toList());
        }
        return new ServiceTicket(ticket.getId(), ticket.getCreatorName(), ticket.getCreateTime().getSeconds(), serviceIssues);
    }
}
