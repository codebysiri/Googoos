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

    @ResponseBody
    @RequestMapping(value = "/nickCheck", method = RequestMethod.POST)
    public int nickCheck(String nickname) throws Exception {
        int result = memberService.nickCheck(nickname);
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/phoneCheck", method = RequestMethod.POST)
    public int phoneCheck(String phone_number) throws Exception {
        int result = memberService.phoneCheck(phone_number);
        return result;
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String registerPOST(MemberDTO memberDTO, String email, String nickname, String phone_number) throws Exception {
        int emailResult = memberService.emailCheck(email);
        int nickResult = memberService.nickCheck(nickname);
        int phoneResult = memberService.phoneCheck(phone_number);

        try {
            if (emailResult == 1 || nickResult == 1 || phoneResult == 1) {
                return "/member/signup";
            } else if (emailResult == 0 && nickResult == 0 && phoneResult == 0) {
                memberService.register(memberDTO);
                return "redirect:/member/login";
            }
        } catch (Exception e) {
            throw new RuntimeException();
        }
        return "redirect:/";
    }
}