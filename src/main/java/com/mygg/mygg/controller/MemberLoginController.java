package com.mygg.mygg.controller;

import com.mygg.mygg.dto.LoginDTO;
import com.mygg.mygg.service.MemberService;
import com.mygg.mygg.vo.MemberVO;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/member")
public class MemberLoginController {

    private final MemberService memberService;

    @Inject
    public MemberLoginController(MemberService memberService) {
        this.memberService = memberService;
    }

    // login page
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginGET(@ModelAttribute("loginDTO")LoginDTO loginDTO) {
        return "/member/login";
    }

    // login 처리
    @RequestMapping(value = "/loginPost", method = RequestMethod.POST)
    public void loginPOST(LoginDTO loginDTO, HttpSession httpSession, Model model) throws Exception {
        MemberVO memberVO = memberService.login(loginDTO);

        if (memberVO == null || !BCrypt.checkpw(loginDTO.getPassword(), memberVO.getPassword())) {
            return;
        }

        model.addAttribute("member", memberVO);
    }



}
