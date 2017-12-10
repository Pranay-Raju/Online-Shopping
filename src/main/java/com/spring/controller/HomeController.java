package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public ModelAndView home(Model model){
		ModelAndView mv = new ModelAndView("welcome");
		return mv;
	}
	@RequestMapping("/admin")
	public ModelAndView admin(Model model){
		ModelAndView mv = new ModelAndView("admin");
		return mv;
	}

}
