package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.model.Product;
import com.spring.service.CategoryService;
import com.spring.service.ProductService;
import com.spring.service.SupplierService;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private SupplierService supplierService;
	
	
	@RequestMapping(value = "/ProductHome", method = RequestMethod.GET)
	public String listProducts(Model model) {
		model.addAttribute("product", new Product());
		model.addAttribute("listProducts", this.productService.listProducts());
		model.addAttribute("categoryList", this.categoryService.listCategories());
		model.addAttribute("supplierList", this.supplierService.listSuppliers());
		model.addAttribute("ProductPageClicked", true);
		return "admin";
	}
	
	//For add and update product both
	@RequestMapping(value= "/product/add", method = RequestMethod.POST)
	public String addProduct(@ModelAttribute("product") Product product){
		
		if(product.getId() == 0){
			//new product, add it
			this.productService.addProduct(product);
		}else{
			//existing product, call update
			this.productService.updateProduct(product);
		}
		
		return "redirect:/ProductHome";
		
	}
	
	@RequestMapping("/removeProduct/{id}")
    public String removeProduct(@PathVariable("id") int id){
		
        this.productService.removeProduct(id);
        return "redirect:/ProductHome";
    }
 
    @RequestMapping("/editProduct/{id}")
    public String editProduct(@PathVariable("id") int id, Model model){
        model.addAttribute("product", this.productService.getProductById(id));
        model.addAttribute("listProducts", this.productService.listProducts());
        return "product";
    }
	
}