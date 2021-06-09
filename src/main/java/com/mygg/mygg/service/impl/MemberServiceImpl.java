package com.mygg.mygg.service.impl;

import com.mygg.mygg.domain.repository.MemberRepository;
import com.mygg.mygg.dto.MemberDTO;
import com.mygg.mygg.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    // Login
    @Override
    public Map<String, String> login(MemberDTO memberDTO) throws Exception {
        return memberRepository.login(memberDTO);
    }

    // JOIN
    @Override
    public void register(MemberDTO memberDTO) {
        memberRepository.register(memberDTO);
    }

    // MyPage
//    @Override
//    public void introduction(MemberDTO memberDTO) {
//        memberRepository.introduction(memberDTO);
//    }

    @Override
    public int introduction(Map<String, String> introduction) {
        return memberRepository.introduction(introduction);
    }

    @Override
    public Map<String, String> marketList(int id) throws Exception {
        return memberRepository.marketList(id);
    }

    @Override
    public Map<String, String> wish(int id) {
        return memberRepository.wish(id);
    }

    // Admin
    @Override
    public List<Map<String, Object>> memberList(Integer member_page) {
        return memberRepository.memberList(member_page);
    }

    @Override
    public Double getTotal() {
        return memberRepository.getTotal();
    }

    @Override
    public int disableMember(Map<String, String> disable) {
        return memberRepository.disableMember(disable);
    }


}