package com.mygg.mygg.service.impl;

import com.mygg.mygg.dao.MemberDAO;
import com.mygg.mygg.dto.LoginDTO;
import com.mygg.mygg.dto.MemberDTO;
import com.mygg.mygg.service.MemberService;
import com.mygg.mygg.vo.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
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
    public Map<String, String> login(LoginDTO loginDTO) throws Exception {
        return memberDAO.login(loginDTO);
    }

}