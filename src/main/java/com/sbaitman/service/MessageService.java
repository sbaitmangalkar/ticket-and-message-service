package com.sbaitman.service;

import com.sbaitman.dao.MessageRepository;
import com.sbaitman.message.proto.Message;
import com.sbaitman.model.GenericMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;

    public GenericMessage findMessageById(String id) {
        Message message = this.messageRepository.findById(id);
        if(message == null) {
            return new GenericMessage("NA", "NA", "NA", 0L);
        }
        return new GenericMessage(message.getId(), message.getMessage(), message.getGeneratorId(), message.getCreateTime().getSeconds());
    }
}
