package com.mygg.mygg.domain.repository;

import com.mygg.mygg.dto.MemberDTO;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface MemberRepository {

    // JOIN
    void register(MemberDTO memberDTO) throws Exception;
    int emailCheck(String email) throws Exception;
    int nickCheck(String nickname) throws Exception;
    int phoneCheck(String phone_number) throws Exception;

    // Login
    Map<String, String> login(MemberDTO memberDTO);

    // MyPage
    int introduction(Map<String, String> introduction);
    Map<String, String> marketList(int id);
    Map<String, String> wish(int id);

    // Admin
    List<Map<String, Object>> memberList(Integer member_page);
    Double getTotal();
    int disableMember(Map<String, String> disable);

}