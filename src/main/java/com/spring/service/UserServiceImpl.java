package com.spring.service;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.dao.UserDAO;
import com.spring.model.User;

@Repository
@Transactional
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDAO userDAO;

	public boolean saveOrUpdate(User user) {
		// TODO Auto-generated method stub
		return userDAO.saveOrUpdate(user);
	}

	public List<User> list() {
		// TODO Auto-generated method stub
		return null;
	}

	public User getUserById(int user_id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void removeUserById(int user_id) {
		// TODO Auto-generated method stub
		
	}

	public User get(String email) {
		// TODO Auto-generated method stub
		return userDAO.get(email);
	}

}
