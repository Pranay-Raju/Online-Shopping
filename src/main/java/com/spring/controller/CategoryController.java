package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.model.Category;
import com.spring.service.CategoryService;

@Controller
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	
	@RequestMapping(value = "/categories", method = RequestMethod.GET)
	public String listCategories(Model model) {
		model.addAttribute("category", new Category());
		model.addAttribute("listCategories", this.categoryService.listCategories());
		return "category";
	}
	
	//For add and update category both
	@RequestMapping(value= "/category/add", method = RequestMethod.POST)
	public String addCategory(@ModelAttribute("category") Category category){
		
		if(category.getId() == 0){
			//new category, add it
			this.categoryService.addCategory(category);
		}else{
			//existing category, call update
			this.categoryService.updateCategory(category);
		}
		
		return "redirect:/categories";
		
	}
	
	@RequestMapping("/removeCategory/{id}")
    public String removeCategory(@PathVariable("id") int id){
		
        this.categoryService.removeCategory(id);
        return "redirect:/categories";
    }
 
    @RequestMapping("/editCategory/{id}")
    public String editCategory(@PathVariable("id") int id, Model model){
        model.addAttribute("category", this.categoryService.getCategoryById(id));
        model.addAttribute("listCategories", this.categoryService.listCategories());
        return "category";
    }
	
}