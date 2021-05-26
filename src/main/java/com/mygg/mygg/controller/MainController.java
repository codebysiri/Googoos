package com.mygg.mygg.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);

	// 메인 페이지
	@GetMapping("/")
	public String index() {
		return "/member/index";
	}

	@RequestMapping("/main")
	public String main() {
		return "service/main";
	}
}
