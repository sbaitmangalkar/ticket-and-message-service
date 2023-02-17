package com.sbaitman.controller;

import com.sbaitman.model.GenericMessage;
import com.sbaitman.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {
    @Autowired
    private MessageService messageService;

    @RequestMapping(path = "/messages/{id}", produces = "application/json")
    public GenericMessage findMessageById(@PathVariable String id) {
        return this.messageService.findMessageById(id);
    }

}
