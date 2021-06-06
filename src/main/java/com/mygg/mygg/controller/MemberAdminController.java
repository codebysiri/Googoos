package com.mygg.mygg.controller;

import com.mygg.mygg.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberAdminController {

    private final MemberService memberService;

    @Autowired
    public MemberAdminController(MemberService memberService) {
        this.memberService = memberService;
    }

    // Member List

}
