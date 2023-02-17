package com.sbaitman.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ServiceIssue {
    private String id;
    private String assignee;
    private String description;
    private String priority;
}
