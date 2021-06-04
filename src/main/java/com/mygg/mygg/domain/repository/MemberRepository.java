package com.mygg.mygg.domain.repository;

import com.mygg.mygg.dto.MemberDTO;

import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface MemberRepository {

    // JOIN
    void register(MemberDTO memberDTO) ;

    // Login
    Map<String, String> login(MemberDTO memberDTO) ;

    // MyPage
    Map<String, String> activity(int id);
    void introduction(MemberDTO memberDTO);


}