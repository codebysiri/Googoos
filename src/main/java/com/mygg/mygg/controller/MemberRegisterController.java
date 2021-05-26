package com.mygg.mygg.controller;

import com.mygg.mygg.dto.MemberDTO;
import com.mygg.mygg.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
public class MemberRegisterController {

    @Autowired
    private MemberService memberService;

    // Join page
    @GetMapping("/signup")
    public String registerGET() {
        return "/member/signup";
    }

    // Join 처리
    @PostMapping("/signup")
    public String registerPOST(MemberDTO memberDTO) {
        memberService.register(memberDTO);
        return "redirect:/member/login";
    }
}