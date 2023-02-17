package com.sbaitman.dao;

import com.sbaitman.message.proto.Message;

import java.util.List;

public interface MessageRepository {
    Message findById(String id);
}
