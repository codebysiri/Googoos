package com.mygg.mygg.controller;

import com.mygg.mygg.dto.MemberDTO;
import com.mygg.mygg.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/member")
public class MemberRegisterController {

    @Autowired
    private MemberService memberService;

    // Join page
    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public void registerGET() throws Exception {

    }

    @ResponseBody
    @RequestMapping(value = "/emailCheck", method = RequestMethod.POST)
    public int emailCheck(String email) throws Exception {
        int result = memberService.emailCheck(email);
        return result;
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String registerPOST(MemberDTO memberDTO, String email) throws Exception {
        int result = memberService.emailCheck(email);
        try {
            if (result == 1) {
                return "/member/signup";
            } else if (result == 0) {
                memberService.register(memberDTO);
                return "redirect:/member/login";
            }
        } catch (Exception e) {
            throw new RuntimeException();
        }
        return "redirect:/";
    }
}