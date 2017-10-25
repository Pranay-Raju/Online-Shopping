package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dao.CategoryDAO;
import com.spring.model.Category;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryDAO personDAO;

	public void setCategoryDAO(CategoryDAO personDAO) {
		this.personDAO = personDAO;
	}

	
	public void addCategory(Category category) {
		this.personDAO.addCategory(category);
	}

	
	public void updateCategory(Category category) {
		this.personDAO.updateCategory(category);
	}

	
	public List<Category> listCategories() {
		return this.personDAO.listCategories();
	}

	
	public Category getCategoryById(int id) {
		return this.personDAO.getCategoryById(id);
	}

	
	public void removeCategory(int id) {
		this.personDAO.removeCategory(id);
	}

}