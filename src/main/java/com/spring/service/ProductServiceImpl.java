package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dao.ProductDAO;
import com.spring.model.Product;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDAO personDAO;

	public void setProductDAO(ProductDAO personDAO) {
		this.personDAO = personDAO;
	}

	
	public void addProduct(Product product) {
		this.personDAO.addProduct(product);
	}

	
	public void updateProduct(Product product) {
		this.personDAO.updateProduct(product);
	}

	
	public List<Product> listProducts() {
		return this.personDAO.listProducts();
	}

	
	public Product getProductById(int id) {
		return this.personDAO.getProductById(id);
	}

	
	public void removeProduct(int id) {
		this.personDAO.removeProduct(id);
	}

}