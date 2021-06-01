package com.mygg.mygg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RestController;

import com.mygg.mygg.model.MessageModel;
import com.mygg.mygg.storage.UserStorage;

@RestController
public class MessageController {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    // 메세지 권한으로 수신 대상의 사용자 수신
    @MessageMapping("/chat/{to}")
    public void sendMessage(@DestinationVariable String to, MessageModel message) {
        System.out.println("handling send message: " + message + " to: " + to);
        boolean isExist = UserStorage.getInstance().getUsers().contains(to);
        if(isExist){
            simpMessagingTemplate.convertAndSend("/topic/messages/" + to, message);
        }
    }
}