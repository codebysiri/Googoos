package com.mygg.mygg.service;

import java.util.List;
import java.util.Map;

public interface NoticeService {
    List<Map<String,Object>> getNotices(Integer board_page);
    Map<String,Object> getNotice(int board_id);
    int insertNotice(Map<String,String> writedValue);
    int updateNotice(Map<String,String> updatedValue);
    int deleteNotice(int board_id);
    List<Map<String,Object>> searchNotices(Map<String,String> searchValue);
    Double getTotal();

}