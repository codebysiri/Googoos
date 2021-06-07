package com.mygg.mygg.service.impl;

import com.mygg.mygg.domain.repository.ChatRepository;
import com.mygg.mygg.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ChatServiceImpl implements ChatService {

    @Autowired
    ChatRepository chatRepository;

    @Override
    public List<Map<String, Object>> getChats(String nickName) {
        return chatRepository.getChats(nickName);
    }

    @Override
    public List<Map<String, Object>> getChat(int room_id) {
        return chatRepository.getChat(room_id);
    }

    @Override
    public int insertChat(HashMap<String, Object> form_value) {
        return chatRepository.insertChat(form_value);
    }

}