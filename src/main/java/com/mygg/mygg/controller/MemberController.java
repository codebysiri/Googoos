package com.mygg.mygg.controller;

import com.mygg.mygg.dto.MemberDto;
import com.mygg.mygg.service.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class MemberController {
    private MemberService memberService;

    // 메인 페이지
    @GetMapping("/")
    public String index() {
        return "/member/index";
    }

    // 회원가입 페이지
    @GetMapping("/user/signup")
    public String dispSignup() {
        return "/member/signup";
    }

    // 회원가입 처리
    @PostMapping("/user/signup")
    public String execSignup(MemberDto memberDto) {
        memberService.joinUser(memberDto);

        return "redirect:/user/login";
    }

    // 로그인 페이지
    @GetMapping("/user/login")
    public String dispLogin() {
        return "/member/login";
    }

    // 로그인 결과 페이지
    @GetMapping("/user/login/result")
    public String dispLoginResult() {
        return "/member/loginSuccess";
    }

    // 로그아웃 결과 페이지
    @GetMapping("/user/logout/result")
    public String dispLogout() {
        return "/member/logout";
    }

    // 접근 거부 페이지
    @GetMapping("/user/denied")
    public String dispDenied() {
        return "/member/denied";
    }

    // 내 정보 페이지
    @GetMapping("/user/info")
    public String dispMyInfo() {
        return "/member/myinfo";
    }

    // 어드민 페이지
    @GetMapping("/admin")
    public String dispAdmin() {
        return "/member/admin";
    }
}
