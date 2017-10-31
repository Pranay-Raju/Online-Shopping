package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.model.KartItem;
import com.spring.service.KartItemService;
import com.spring.service.KartService;
import com.spring.service.ProductService;


@Controller
public class KartItemController {
	
	@Autowired
	private KartItemService kartItemService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private KartService kartService;
	
	
	@RequestMapping(value = "/KartItemHome", method = RequestMethod.GET)
	public String listKartItems(Model model) {
		model.addAttribute("kartItem", new KartItem());
		model.addAttribute("listKartItems", this.kartItemService.listKartItems());
		model.addAttribute("productList", this.productService.listProducts());
		model.addAttribute("karts", this.kartService.listKarts());
		model.addAttribute("KartItemPageClicked", true);
		return "admin";
	}
	
	//For add and update kartItem both
	@RequestMapping(value= "/kartItem/add", method = RequestMethod.POST)
	public String addKartItem(@ModelAttribute("kartItem") KartItem kartItem){
		
		if(kartItem.getId() == 0){
			//new kartItem, add it
			this.kartItemService.addKartItem(kartItem);
		}else{
			//existing kartItem, call update
			this.kartItemService.updateKartItem(kartItem);
		}
		
		return "redirect:/KartItemHome";
		
	}
	
	@RequestMapping("/removeKartItem/{id}")
    public String removeKartItem(@PathVariable("id") int id){
		
        this.kartItemService.removeKartItem(id);
        return "redirect:/KartItemHome";
    }
 
    @RequestMapping("/editKartItem/{id}")
    public String editKartItem(@PathVariable("id") int id, Model model){
        model.addAttribute("kartItem", this.kartItemService.getKartItemById(id));
        model.addAttribute("listKartItems", this.kartItemService.listKartItems());
        return "kartItem";
    }
	
}