package com.spring.dao;

import java.util.List;

import com.spring.model.Product;

public interface ProductDAO {

	public void addProduct(Product product);
	public void updateProduct(Product product);
	public List<Product> listProducts();
	public Product getProductById(int id);
	public void removeProduct(int id);
}
