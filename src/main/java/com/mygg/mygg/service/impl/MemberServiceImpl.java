package com.mygg.mygg.service.impl;

import com.mygg.mygg.dao.MemberDAO;
import com.mygg.mygg.dto.LoginDTO;
import com.mygg.mygg.service.MemberService;
import com.mygg.mygg.vo.MemberVO;

import javax.inject.Inject;

public class MemberServiceImpl implements MemberService {

    private final MemberDAO memberDAO;

    @Inject
    public MemberServiceImpl(MemberDAO memberDAO) {
        this.memberDAO = memberDAO;
    }

    @Override
    public void register(MemberVO memberVO) throws Exception {
        memberDAO.register(memberVO);
    }

    @Override
    public MemberVO login(LoginDTO loginDTO) throws Exception {
        return memberDAO.login(loginDTO);
    }
}
