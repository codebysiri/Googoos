package com.mygg.mygg.service.impl;

import com.mygg.mygg.domain.repository.MemberRepository;
import com.mygg.mygg.dto.MemberDTO;
import com.mygg.mygg.dto.MyPageDTO;
import com.mygg.mygg.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void register(MemberDTO memberDTO) {
        memberRepository.register(memberDTO);
    }

    @Override
    public Map<String, String> login(MemberDTO memberDTO) throws Exception {
        return memberRepository.login(memberDTO);
    }

    @Override
    public Map<String, String> activity(int id) throws Exception {
        return memberRepository.activity(id);
    }

    @Override
    public void introduction(MyPageDTO myPageDTO) {
        memberRepository.introduction(myPageDTO);
    }
}