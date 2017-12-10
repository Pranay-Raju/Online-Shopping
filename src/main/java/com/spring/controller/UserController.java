package com.spring.controller;

import java.util.Collection;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.model.Product;
import com.spring.model.User;
import com.spring.service.CategoryService;
import com.spring.service.SupplierService;
import com.spring.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private SupplierService supplierService;
	@Autowired
	private CategoryService categoryService;
	
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
	
	@RequestMapping("/login")	
    public String login(@RequestParam(value="error",required=false) String error,
    		@RequestParam(value="logout",required=false) String logout,
    		Model model){
    	if(error!=null)
    		model.addAttribute("error","Invalid Username and Password.. Please enter valid username and password");
    	if(logout!=null)
    		model.addAttribute("logout","Loggedout successfully");
    		model.addAttribute("LoginPageClicked", true);
    	return "admin";
    }
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/login_session_attributes")
	public String login_session_attributes(HttpSession session,Model model) {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		User user = userService.get(username);
		session.setAttribute("userId", user.getId());
		session.setAttribute("name", user.getFirstName());
		session.setAttribute("LoggedIn", "true");
		Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>) SecurityContextHolder.getContext()
		.getAuthentication().getAuthorities();
		String role="ROLE_USER";
		for (GrantedAuthority authority : authorities) 
		{
		  
		     if (authority.getAuthority().equals(role)) 
		     {
		    	 session.setAttribute("UserLoggedIn", "true");
//		    	 session.setAttribute("cartsize",cartService.cartsize((int)session.getAttribute("userId")));
		     }
		     else 
		     {
		    	 session.setAttribute("Administrator", "true");
		    	 model.addAttribute("product",  new Product());
		    	 model.addAttribute("ProductPageClicked", "true");
		    	 model.addAttribute("supplierList",supplierService.listSuppliers());
		    	 model.addAttribute("categoryList",categoryService.listCategories());
			 }
		}
		return "welcome";
	}

}
