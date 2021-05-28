package com.mygg.mygg.controller;

import com.mygg.mygg.dto.MemberDTO;
import com.mygg.mygg.dto.MyPageDTO;
import com.mygg.mygg.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping("/member")
public class MyPageController {

    private final MemberService memberService;

    @Autowired
    public MyPageController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/info")
    public String myPage(MyPageDTO myPageDTO, HttpSession httpSession) throws Exception {

        Map<String, String> memberActivity = memberService.activity(myPageDTO);

        if(memberActivity.get("id") != null) {
            httpSession.setAttribute("level", memberActivity.get("level"));
            httpSession.setAttribute("wish", memberActivity.get("wish"));
            httpSession.setAttribute("batch", memberActivity.get("batch"));
            httpSession.setAttribute("mileage", memberActivity.get("mileage"));
            return "/member/myinfo";
        } else {
            return "redirect:/member/login";
        }
    }

}