package com.mygg.mygg.service;

import com.mygg.mygg.dto.MemberDTO;

import java.util.Map;

public interface MemberService {

    // join
    void register(MemberDTO memberDTO);

    // login
    Map<String, String> login(MemberDTO memberDTO) throws Exception;

    // myPage
    void introduction(MemberDTO memberDTO);
    Map<String, String> marketList(int id) throws Exception;


}