package com.mygg.mygg.domain.repository;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface NoticeRepository {
    List<Map<String,Object>> getNotices(Integer board_page);   // 마이바티스와 직접 매핑되는 List불러오기
    Map<String,Object> getNotice(int board_id);
    int insertNotice(Map<String,String> writedValue);
    int updateNotice(Map<String,String> updatedValue);
    int deleteNotice(int board_id);
    List<Map<String,Object>> searchNotices(Map<String,String> searchValue);
    Double getTotal();

}
