package com.sbaitman.dao;

import com.google.protobuf.Timestamp;
import com.sbaitman.ticket.proto.Ticket;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.*;

@Repository
public class TicketRepositoryImpl {
    @Bean
    public TicketRepository ticketRepository() {
        Map<String, Ticket> tickets = new HashMap<>();
        //Create some dummy tickets
        var issue0 = createIssue("rrawat", "unable to access GitHub");
        var issue1 = createIssue("rrawat", "unable to access GitLab");

        var issue2 = createIssue("nmishra", "unable to generate access token");
        Arrays.asList(
                createTicket("TIK00", "CRE00", "sbaitmangalkar", Arrays.asList(issue0, issue1)),
                createTicket("TIK01", "CRE01", "praghav", Arrays.asList(issue2))
        ).forEach(t -> tickets.put(t.getId(), t));
        return tickets::get;
    }

    private Ticket.Issue createIssue(String assignee, String description) {
        return Ticket.Issue.newBuilder().setId(UUID.randomUUID().toString())
                .setPriority(Ticket.IssuePriority.HIGH)
                .setDescription(description)
                .setAssignee(assignee)
                .build();
    }

    private Ticket createTicket(String ticketId, String creatorId, String creatorName, List<Ticket.Issue> issues) {
        return Ticket.newBuilder().setId(ticketId)
                .setCreatorId(creatorId)
                .setCreateTime(Timestamp.newBuilder().setSeconds(Instant.now().toEpochMilli()).build())
                .setCreatorName(creatorName)
                .addAllIssues(issues)
                .build();
    }
}
