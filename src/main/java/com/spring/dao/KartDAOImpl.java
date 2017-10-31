package com.spring.dao;


import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.model.Kart;

@Repository
@Transactional
public class KartDAOImpl implements KartDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(KartDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	public void addKart(Kart kart) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(kart);
		logger.info("Kart saved successfully, Kart Details="+kart);
	}

	public void updateKart(Kart kart) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(kart);
		logger.info("Kart updated successfully, Kart Details="+kart);
	}

	
	@SuppressWarnings("unchecked")
	public List<Kart> listKarts() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Kart> kartsList = session.createQuery("from Kart").list();
		for(Kart kart : kartsList){
			logger.info("Kart List::"+kart);
		}
		return kartsList;
	}

	public Kart getKartById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		Kart kart = (Kart) session.load(Kart.class, new Integer(id));
		logger.info("Kart loaded successfully, Kart details="+kart);
		return kart;
	}

	public void removeKart(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Kart kart = (Kart) session.load(Kart.class, new Integer(id));
		if(null != kart){
			session.delete(kart);
		}
		logger.info("Kart deleted successfully, kart details="+kart);
	}

}