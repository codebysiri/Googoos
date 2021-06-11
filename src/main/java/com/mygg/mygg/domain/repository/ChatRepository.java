package com.mygg.mygg.domain.repository;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mapper
public interface ChatRepository {
    List<Map<String,Object>> getChats(String nickName);
    List<Map<String,Object>> getChat(int room_id);
    int insertChat(HashMap<String, Object> form_value);
    int insertChatRoom(HashMap<String, Object> value);
    Map<String, Object> getRoomStatus(int room_id);
    int accept(HashMap<String, Object> acceptValue);
    Map<String, Object> getMarket(int room_id);
    int upDateReview(HashMap<String,Object> formData);
}