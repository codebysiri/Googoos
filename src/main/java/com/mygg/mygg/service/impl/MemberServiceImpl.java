package com.mygg.mygg.service.impl;

import com.mygg.mygg.dao.MemberDAO;
import com.mygg.mygg.dto.MemberDTO;
import com.mygg.mygg.dto.MyPageDTO;
import com.mygg.mygg.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class MemberServiceImpl implements MemberService {

    private final MemberDAO memberDAO;

    @Autowired
    public MemberServiceImpl(MemberDAO memberDAO) {
        this.memberDAO = memberDAO;
    }

    @Override
    public void register(MemberDTO memberDTO) {
        memberDAO.register(memberDTO);
    }

    @Override
    public Map<String, String> login(MemberDTO memberDTO) throws Exception {
        return memberDAO.login(memberDTO);
    }

    @Override
    public Map<String, String> activity(MyPageDTO myPageDTO) throws Exception {
        return memberDAO.activity(myPageDTO);
    }
}