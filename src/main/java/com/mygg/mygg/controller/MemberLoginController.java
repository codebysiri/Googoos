package com.mygg.mygg.controller;

import com.mygg.mygg.dto.LoginDTO;
import com.mygg.mygg.service.MemberService;
import com.mygg.mygg.vo.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.inject.Inject;
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
    public String loginGET(@ModelAttribute("loginDTO")LoginDTO loginDTO) {
        return "/member/login";
    }


    @PostMapping("/user/login")
    public String loginPOST(LoginDTO dto, HttpServletRequest request) throws Exception {

        HttpSession session = request.getSession();
        System.out.println(dto.getEmail());
        Map<String,String> member_inform = memberService.login(dto);
        System.out.println(member_inform);
        if(member_inform.get("email").equals(dto.getEmail()) && member_inform.get("password").equals(dto.getPassword())){
        session.setAttribute("memberId",member_inform.get("id"));
            System.out.println("세션이 들어갔습니다");
            return "member/loginSuccess";
        }else{
            System.out.println("비밀번호가 틀립니다.");
          return "redirect:/";
        }
    }

    // login 처리
//    @RequestMapping(value = "/loginPost", method = RequestMethod.POST)
//    public void loginPOST(LoginDTO loginDTO, HttpSession httpSession, Model model) throws Exception {
//        MemberVO memberVO = memberService.login(loginDTO);
//
//        if (memberVO == null || !BCrypt.checkpw(loginDTO.getPassword(), memberVO.getPassword())) {
//            return;
//        }
//
//        model.addAttribute("member", memberVO);
//    }



}

