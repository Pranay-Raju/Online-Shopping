package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.model.User;
import com.spring.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/register")
	public String DisplayRegister(Model mv) {
		mv.addAttribute("user", new User());
		mv.addAttribute("Register", "true");
		return "welcome";
	}

	@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
	public String UserRegister(@ModelAttribute("user") User user,RedirectAttributes attributes) {
		user.setEnabled(true);
		user.setRole("ROLE_USER");
		userService.saveOrUpdate(user);
		attributes.addFlashAttribute("SuccessMessage","Registration Successfull");
		return "redirect:/";
	}

}
