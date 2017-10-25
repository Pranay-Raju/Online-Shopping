package com.spring.dao;

import java.util.List;

import com.spring.model.Category;

public interface CategoryDAO {

	public void addCategory(Category category);
	public void updateCategory(Category category);
	public List<Category> listCategories();
	public Category getCategoryById(int id);
	public void removeCategory(int id);
}
