package com.mygg.mygg.controller;

import com.mygg.mygg.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;
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
    public String myPage(HttpSession httpSession, Model model) throws Exception {

        if(httpSession.getAttribute("id") != null) {
            Integer id = (int) httpSession.getAttribute("id");
            List<Map<String, Object>> marketList = memberService.marketList(id);
            List<Map<String, Object>> wish = memberService.wish(id);

            model.addAttribute(marketList);
            model.addAttribute(wish);

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

    // introduction update
    @PostMapping("introduction")
    public String introductionPOST(@RequestParam Map<String, String> introduction) {
        memberService.introduction(introduction);
        return "/member/introduction";
    }
}