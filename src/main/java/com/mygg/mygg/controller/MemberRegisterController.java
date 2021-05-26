package com.mygg.mygg.controller;

import com.mygg.mygg.service.MemberService;
import com.mygg.mygg.vo.MemberVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.inject.Inject;

@Controller
@RequestMapping("/member")
public class MemberRegisterController {

    private final MemberService memberService;

    @Inject
    public MemberRegisterController(MemberService memberService) {
        this.memberService = memberService;
    }

    // 회원 가입
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerGET() throws Exception {
        return "/member/signup";
    }


}