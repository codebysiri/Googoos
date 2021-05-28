package com.mygg.mygg.dao;

import com.mygg.mygg.dto.MemberDTO;
import com.mygg.mygg.dto.MyPageDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface MemberDAO {

    void register(MemberDTO memberDTO) ;
    Map<String, String> login(MemberDTO memberDTO) ;
    Map<String, String> activity(MyPageDTO myPageDTO);
}
