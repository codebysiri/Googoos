package com.mygg.mygg.dao;

import com.mygg.mygg.dto.LoginDTO;
import com.mygg.mygg.vo.MemberVO;

public interface MemberDAO {

    void register(MemberVO memberVO) throws Exception;

    //로그인 처리
    MemberVO login(LoginDTO loginDTO) throws Exception;
}
