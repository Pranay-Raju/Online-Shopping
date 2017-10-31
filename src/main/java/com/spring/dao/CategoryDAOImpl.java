package com.spring.dao;


import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.model.Category;

@Repository
@Transactional
public class CategoryDAOImpl implements CategoryDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(CategoryDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	public void addCategory(Category category) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(category);
		logger.info("Category saved successfully, Category Details="+category);
	}

	public void updateCategory(Category category) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(category);
		logger.info("Category updated successfully, Category Details="+category);
	}

	
	@SuppressWarnings("unchecked")
	public List<Category> listCategories() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Category> categoriesList = session.createQuery("from Category").list();
		for(Category category : categoriesList){
			logger.info("Category List::"+category);
		}
		return categoriesList;
	}

	public Category getCategoryById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		Category category = (Category) session.load(Category.class, new Integer(id));
		logger.info("Category loaded successfully, Category details="+category);
		return category;
	}

	public void removeCategory(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Category category = (Category) session.load(Category.class, new Integer(id));
		if(null != category){
			session.delete(category);
		}
		logger.info("Category deleted successfully, category details="+category);
	}

}