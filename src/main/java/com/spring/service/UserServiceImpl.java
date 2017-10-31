package com.spring.service;

import java.util.List;

import javax.transaction.Transactional;

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
		
		return userDAO.saveOrUpdate(user);
	}

	public List<User> list() {
		
		return null;
	}

	public User getUserById(int user_id) {
		
		return null;
	}

	public void removeUserById(int user_id) {
		
		
	}

	public User get(String email) {
		
		return userDAO.get(email);
	}

}
