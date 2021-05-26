package com.mygg.mygg.service;

import com.mygg.mygg.dto.LoginDTO;
import com.mygg.mygg.vo.MemberVO;
import org.springframework.stereotype.Service;

public interface MemberService {

    void register(MemberVO memberVO) throws Exception;

    MemberVO login(LoginDTO loginDTO) throws Exception;
}