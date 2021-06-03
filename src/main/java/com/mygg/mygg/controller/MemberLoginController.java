package com.mygg.mygg.controller;

import com.mygg.mygg.dto.MemberDTO;
import com.mygg.mygg.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping("/member")
public class MemberLoginController {

    private final MemberService memberService;

    @Autowired
    public MemberLoginController(MemberService memberService) {
        this.memberService = memberService;
    }

    // login page
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginGET(@ModelAttribute("memberDTO")MemberDTO memberDTO) {
        return "/member/login";
    }


    // login session
    @PostMapping("/user/login")
    public String loginPOST(MemberDTO memberDTO, HttpServletRequest request) throws Exception {

        HttpSession session = request.getSession();
        // System.out.println(dto.getEmail());
        Map<String,String> memberInform = memberService.login(memberDTO);
        // System.out.println(memberInform);
        if(memberInform.get("email").equals(memberDTO.getEmail()) && memberInform.get("password").equals(memberDTO.getPassword())){
            session.setAttribute("id", memberInform.get("id"));
            session.setAttribute("photo", memberInform.get("photo"));
            session.setAttribute("nickname", memberInform.get("nickname"));
            session.setAttribute("gender", memberInform.get("gender"));
            session.setAttribute("age", memberInform.get("age"));
            session.setAttribute("location", memberInform.get("location"));
            session.setAttribute("authority", memberInform.get("authority"));

            // System.out.println("세션 생성");
            return "/member/loginSuccess";
        }else{
            // System.out.println("로그인 실패");
            return "redirect:./";
        }
    }

    // logout
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpSession session) throws Exception {
        if (session.getAttribute("id") != null) {
            session.invalidate();
            return "/member/logout";
        } else {
            return "/member/denied";
        }
    }

}