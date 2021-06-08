package com.mygg.mygg.controller;

import com.mygg.mygg.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MemberAdminController {

    private final MemberService memberService;

    @Autowired
    public MemberAdminController(MemberService memberService) {
        this.memberService = memberService;
    }

    // Member List
    @GetMapping(value ={"/member/admin/{member_page}", "/member/admin"})
    public String memberList(@PathVariable(required = false) Integer member_page, Model model) {

        Double total = memberService.getTotal();
        int totalPage = (int) Math.ceil(total / 20);

        if(member_page != null) {
            model.addAttribute("members", memberService.memberList((member_page - 1) * 10 * 2));
            model.addAttribute("totalPage", totalPage);
        } else {
            member_page = 1;
            model.addAttribute("members", memberService.memberList((member_page - 1) * 10 * 2));
            model.addAttribute("totalPage", totalPage);
        }
        return "/member/admin";
    }

}
