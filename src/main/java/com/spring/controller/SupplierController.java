package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.model.Supplier;
import com.spring.service.SupplierService;

@Controller
public class SupplierController {
	
	@Autowired
	private SupplierService supplierService;
	
	
	@RequestMapping(value = "/SupplierHome", method = RequestMethod.GET)
	public String listSuppliers(Model model) {
		model.addAttribute("supplier", new Supplier());
		model.addAttribute("listSuppliers", this.supplierService.listSuppliers());
		return "supplier";
	}
	
	//For add and update supplier both
	@RequestMapping(value= "/supplier/add", method = RequestMethod.POST)
	public String addSupplier(@ModelAttribute("supplier") Supplier supplier){
		
		if(supplier.getId() == 0){
			//new supplier, add it
			this.supplierService.addSupplier(supplier);
		}else{
			//existing supplier, call update
			this.supplierService.updateSupplier(supplier);
		}
		
		return "redirect:/SupplierHome";
		
	}
	
	@RequestMapping("/removeSupplier/{id}")
    public String removeSupplier(@PathVariable("id") int id){
		
        this.supplierService.removeSupplier(id);
        return "redirect:/SupplierHome";
    }
 
    @RequestMapping("/editSupplier/{id}")
    public String editSupplier(@PathVariable("id") int id, Model model){
        model.addAttribute("supplier", this.supplierService.getSupplierById(id));
        model.addAttribute("listSuppliers", this.supplierService.listSuppliers());
        return "supplier";
    }
	
}