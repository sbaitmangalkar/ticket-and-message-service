package com.sbaitman.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class GenericMessage {
    private String id;
    private String message;
    private String generator;
    private long createdAt;
}
