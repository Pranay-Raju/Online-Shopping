package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.model.Kart;
import com.spring.service.KartService;
import com.spring.service.UserService;

@Controller
public class KartController {
	
	@Autowired
	private KartService kartService;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/KartHome", method = RequestMethod.GET)
	public String listKarts(Model model) {
		model.addAttribute("kart", new Kart());
		model.addAttribute("listKarts", this.kartService.listKarts());
		model.addAttribute("userList", this.userService.list());
		model.addAttribute("KartPageClicked", true);
		return "admin";
	}
	
	//For add and update kart both
	@RequestMapping(value= "/kart/add", method = RequestMethod.POST)
	public String addKart(@ModelAttribute("kart") Kart kart){
		
		if(kart.getId() == 0){
			//new kart, add it
			this.kartService.addKart(kart);
		}else{
			//existing kart, call update
			this.kartService.updateKart(kart);
		}
		
		return "redirect:/KartHome";
		
	}
	
	@RequestMapping("/removeKart/{id}")
    public String removeKart(@PathVariable("id") int id){
		
        this.kartService.removeKart(id);
        return "redirect:/KartHome";
    }
 
    @RequestMapping("/editKart/{id}")
    public String editKart(@PathVariable("id") int id, Model model){
        model.addAttribute("kart", this.kartService.getKartById(id));
        model.addAttribute("listKarts", this.kartService.listKarts());
        return "kart";
    }
	
}