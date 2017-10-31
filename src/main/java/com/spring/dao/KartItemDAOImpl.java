package com.spring.dao;


import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.model.KartItem;

@Repository
@Transactional
public class KartItemDAOImpl implements KartItemDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(KartItemDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	public void addKartItem(KartItem kartItem) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(kartItem);
		logger.info("KartItem saved successfully, KartItem Details="+kartItem);
	}

	public void updateKartItem(KartItem kartItem) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(kartItem);
		logger.info("KartItem updated successfully, KartItem Details="+kartItem);
	}

	
	@SuppressWarnings("unchecked")
	public List<KartItem> listKartItems() {
		Session session = this.sessionFactory.getCurrentSession();
		List<KartItem> kartItemsList = session.createQuery("from KartItem").list();
		for(KartItem kartItem : kartItemsList){
			logger.info("KartItem List::"+kartItem);
		}
		return kartItemsList;
	}

	public KartItem getKartItemById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		KartItem kartItem = (KartItem) session.load(KartItem.class, new Integer(id));
		logger.info("KartItem loaded successfully, KartItem details="+kartItem);
		return kartItem;
	}

	public void removeKartItem(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		KartItem kartItem = (KartItem) session.load(KartItem.class, new Integer(id));
		if(null != kartItem){
			session.delete(kartItem);
		}
		logger.info("KartItem deleted successfully, kartItem details="+kartItem);
	}

}