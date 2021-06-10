package com.mygg.mygg.service;

import com.mygg.mygg.dto.MemberDTO;

import java.util.List;
import java.util.Map;

public interface MemberService {

    // join
    void register(MemberDTO memberDTO) throws Exception;
    int emailCheck(String email) throws Exception;
    int nickCheck(String nickname) throws Exception;
    int phoneCheck(String phone_number) throws Exception;

    // login
    Map<String, String> login(MemberDTO memberDTO) throws Exception;

    // myPage
    int introduction(Map<String, String> introduction);
    List<Map<String, Object>> marketList(int id);
    List<Map<String, Object>> wish(int id);

    // Admin
    List<Map<String, Object>> memberList(Integer member_page);
    Double getTotal();
    int disableMember(Map<String, String> disable);

}