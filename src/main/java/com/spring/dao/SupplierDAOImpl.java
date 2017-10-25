package com.spring.dao;


import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.model.Supplier;

@Repository
@Transactional
public class SupplierDAOImpl implements SupplierDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(SupplierDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	public void addSupplier(Supplier supplier) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(supplier);
		logger.info("Supplier saved successfully, Supplier Details="+supplier);
	}

	public void updateSupplier(Supplier supplier) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(supplier);
		logger.info("Supplier updated successfully, Supplier Details="+supplier);
	}

	
	public List<Supplier> listSuppliers() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Supplier> suppliersList = session.createQuery("from Supplier").list();
		for(Supplier supplier : suppliersList){
			logger.info("Supplier List::"+supplier);
		}
		return suppliersList;
	}

	public Supplier getSupplierById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		Supplier supplier = (Supplier) session.load(Supplier.class, new Integer(id));
		logger.info("Supplier loaded successfully, Supplier details="+supplier);
		return supplier;
	}

	public void removeSupplier(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Supplier supplier = (Supplier) session.load(Supplier.class, new Integer(id));
		if(null != supplier){
			session.delete(supplier);
		}
		logger.info("Supplier deleted successfully, supplier details="+supplier);
	}

}