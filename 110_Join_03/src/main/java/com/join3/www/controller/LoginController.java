package com.join3.www.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.join3.www.service.JoinService;

@Controller
public class LoginController {
	
	public LoginController() {
		System.out.println("-------------생성완-----------");
	}
	
	@RequestMapping("/index.do")
	public String indexPage() {
		return "login";
	}
	
	@Autowired
	private JoinService joinService;
	
//	@RequestMapping("/join.do")
//	public String join(@RequestParam HashMap<String, String> params) {
////		System.out.println("------------------------"+params);
//		joinService.join(params);
//		return "login";
//	}
	@RequestMapping("/join.do")
	public ModelAndView join(@RequestParam HashMap<String, String> params) {
//		System.out.println("------------------------"+params);
		ModelAndView mv = new ModelAndView();
		int result = joinService.join(params);
		mv.addObject("result",result);
		String msg = (result==1) ? "성공" : "실패";
		mv.addObject("msg",msg);
		mv.setViewName("login");
		return mv;
	}
}
