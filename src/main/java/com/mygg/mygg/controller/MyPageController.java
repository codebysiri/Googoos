package com.mygg.mygg.controller;

import com.mygg.mygg.dto.MemberDTO;
import com.mygg.mygg.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
    public String myPage(HttpSession httpSession) throws Exception {

        Integer id = (int) httpSession.getAttribute("id");
        Map<String, String> marketList = memberService.marketList(id);
        Map<String, String> wish = memberService.wish(id);

        if (marketList.get("id") != null) {
            httpSession.setAttribute("type", marketList.get("TYPE"));
            httpSession.setAttribute("title", marketList.get("TITLE"));
            httpSession.setAttribute("price", marketList.get("PRICE"));
            httpSession.setAttribute("rvState", marketList.get("RV_STATE"));
            httpSession.setAttribute("wish", wish.get("JM_SERVICE"));
            return "/member/myinfo";
        } else {
            return "redirect:/member/login";
        }
    }

    // introduction page
    @GetMapping("/introduction")
    public String introductionGET() {
        return "/member/introduction";
    }

    // introduction 입력 처리
    @PostMapping("/introduction")
    public String introductionPOST(MemberDTO memberDTO) {
        memberService.introduction(memberDTO);
        return "/member/introduction";
    }


}