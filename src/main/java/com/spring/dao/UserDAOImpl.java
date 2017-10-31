package com.spring.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/*import org.slf4j.Logger;
import org.slf4j.LoggerFactory;*/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.model.User;

@Repository
@Transactional
public class UserDAOImpl implements UserDAO{
	
	private static final Logger logger = LoggerFactory.getLogger(UserDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	public UserDAOImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	public boolean saveOrUpdate(User user) {
		sessionFactory.getCurrentSession().saveOrUpdate(user);
		return true;
	}

	@SuppressWarnings("unchecked")
	public List<User> list() {
		
		Session session = this.sessionFactory.getCurrentSession();
		List<User> usersList = session.createQuery("from User").list();
		for(User user : usersList){
			logger.info("User List::"+user);
		}
		return usersList;
		
		/*return null;*/
	}

	public User getUserById(int user_id) {
		
		return null;
	}

	public void removeUserById(int user_id) {
		
		
	}

	@SuppressWarnings("unchecked")
	public User get(String email) {
		
		Criteria c = sessionFactory.getCurrentSession().createCriteria(User.class);
		c.add(Restrictions.eq("email", email));
		List<User> list = (List<User>) c.list();
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}

}
