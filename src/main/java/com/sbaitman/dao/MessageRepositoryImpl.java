package com.sbaitman.dao;

import com.google.protobuf.Timestamp;
import com.sbaitman.message.proto.Message;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Repository
public class MessageRepositoryImpl {
    @Bean
    MessageRepository messageRepository() {
        Map<String, Message> messages = new HashMap<>();
        Arrays.asList(
                createMessages("MSG00", "hello world!", "sbaitmangalkar"),
                createMessages("MSG01", "have a nice day", "sbaitmangalkar")
        ).forEach(m -> messages.put(m.getId(), m));
        return messages::get;
    }

    private Message createMessages(String id, String message, String generatorId) {
        return Message.newBuilder().setId(id)
                .setMessage(message)
                .setGeneratorId(generatorId)
                .setCreateTime(Timestamp.newBuilder().setSeconds(Instant.now().toEpochMilli()).build())
                .build();
    }
}
