package com.mygg.mygg.controller;

import com.mygg.mygg.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class MemberAdminController {

    private final MemberService memberService;

    @Autowired
    public MemberAdminController(MemberService memberService) {
        this.memberService = memberService;
    }

    // Member List
    @GetMapping(value ={"/member/admin/{member_page}", "/member/admin"})
    public String memberList(@PathVariable(required = false) Integer member_page, Model model, HttpServletRequest request) {

        HttpSession httpSession = request.getSession();
        Double total = memberService.getTotal();
        int totalPage = (int) Math.ceil(total / 20);

        // "authority" 1 - 일반회원 2 - 운영자
        if ((int)httpSession.getAttribute("authority") != 2) {
            String referer = request.getHeader("Referer");
            return "redirect:" + referer;
        }

        if (member_page != null) {
            model.addAttribute("members", memberService.memberList((member_page - 1) * 10 * 2));
            model.addAttribute("totalPage", totalPage);
        } else {
            member_page = 1;
            model.addAttribute("members", memberService.memberList((member_page - 1) * 10 * 2));
            model.addAttribute("totalPage", totalPage);
        }
        return "/member/admin";
    }

    @PostMapping("/admin/update")
    public String disableMember(@RequestParam Map<String, String> disable) {
        memberService.disableMember(disable);
        return "redirect:/member/admin";
    }

}