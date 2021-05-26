package com.mygg.mygg.domain.repository;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
public interface ChatRepository {
    List<Map<String,Object>> getChats();

    void updateStatus(Map<String, String> json);
}
