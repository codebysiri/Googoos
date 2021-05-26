package com.mygg.mygg.service;

import com.mygg.mygg.dto.LoginDTO;
import com.mygg.mygg.vo.MemberVO;
import org.springframework.stereotype.Service;

import java.util.Map;

public interface MemberService {

    void register(MemberVO memberVO) throws Exception;

    Map<String, String> login(LoginDTO loginDTO) throws Exception;
}