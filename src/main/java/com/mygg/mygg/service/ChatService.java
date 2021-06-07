package com.mygg.mygg.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface ChatService {
    List<Map<String,Object>> getChats(String nickName);
    List<Map<String,Object>> getChat(int room_id);
    int insertChat(HashMap<String, Object> form_value);

}