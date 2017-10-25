package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dao.SupplierDAO;
import com.spring.model.Supplier;

@Service
public class SupplierServiceImpl implements SupplierService {
	
	@Autowired
	private SupplierDAO personDAO;

	public void setSupplierDAO(SupplierDAO personDAO) {
		this.personDAO = personDAO;
	}

	
	public void addSupplier(Supplier supplier) {
		this.personDAO.addSupplier(supplier);
	}

	
	public void updateSupplier(Supplier supplier) {
		this.personDAO.updateSupplier(supplier);
	}

	
	public List<Supplier> listSuppliers() {
		return this.personDAO.listSuppliers();
	}

	
	public Supplier getSupplierById(int id) {
		return this.personDAO.getSupplierById(id);
	}

	
	public void removeSupplier(int id) {
		this.personDAO.removeSupplier(id);
	}

}