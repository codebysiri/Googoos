package com.mygg.mygg.service;

import com.mygg.mygg.dto.MemberDTO;
import com.mygg.mygg.dto.MyPageDTO;

import java.util.Map;

public interface MemberService {

    // join
    void register(MemberDTO memberDTO);

    // login
    Map<String, String> login(MemberDTO memberDTO) throws Exception;

    // Activity
    Map<String, String> activity(int id) throws Exception;

    // Introduction
    void introduction(MyPageDTO myPageDTO);

}