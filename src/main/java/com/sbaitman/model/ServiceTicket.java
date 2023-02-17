package com.sbaitman.model;

import com.google.protobuf.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@Getter
public class ServiceTicket {
    private String id;
    private String creator;
    private long createdAt;

    private List<ServiceIssue> issues;
}
