package com.mygg.mygg.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mygg.mygg.dto.MemberDTO;
import com.mygg.mygg.service.MarketService;
import com.mygg.mygg.service.MemberService;
import com.mygg.mygg.vo.MarketVO;

@Controller
@RequestMapping("/market/")
public class MarketAdminController {

    private static final Logger logger = LoggerFactory.getLogger(MarketAdminController.class);
    // Service와 연결
    // URL market/...
    @Resource(name="marketService")
    private MarketService marketService;
    private MemberService memberService;

    @Autowired
    public MarketAdminController(MemberService memberService) {
        this.memberService = memberService;
    }

    /**
     * 기능 - 서비스 목록들
     글 등록을 하고 저장까지 완료가 되면 바로 이 화면으로 넘어온다.
     * URL이름 - marketListPage
     * 화면이름 - marketList.html
     * Method - public String marketListPage(Model model, HttpServletResponse response, HttpServletRequest request, HttpSession session)
     * Parameter(매개변수 ID/PW , 없으면 N/A)
     - MarketVO marketVO, Model model
     * return type(void, String, ServiceVO)
     -
     * 쿼리(DB 작업 insert, select, update, delete)
     - SELECT 컬럼들 FROM MARKET;
     */
    @RequestMapping("adminMarketListPage")
    public String marketListPage(HttpServletResponse response, MemberDTO memberDTO, Model model, HttpServletRequest request, RedirectAttributes redirectAttributes) throws Exception {

        HttpSession session = request.getSession();

        Object admin = session.getAttribute("id");

        if(admin != null) {

            List<MarketVO> marketList = marketService.marketList();

            model.addAttribute("marketList", marketList);

            return "service/adminMarketList";
        } else {
            return "redirect:/member/login";
        }

    }
}