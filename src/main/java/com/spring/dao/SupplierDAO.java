package com.spring.dao;

import java.util.List;

import com.spring.model.Supplier;

public interface SupplierDAO {

	public void addSupplier(Supplier supplier);
	public void updateSupplier(Supplier supplier);
	public List<Supplier> listSuppliers();
	public Supplier getSupplierById(int id);
	public void removeSupplier(int id);
}
