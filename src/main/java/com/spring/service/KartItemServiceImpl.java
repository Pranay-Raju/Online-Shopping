package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dao.KartItemDAO;
import com.spring.model.KartItem;

@Service
public class KartItemServiceImpl implements KartItemService {
	
	@Autowired
	private KartItemDAO personDAO;

	public void setKartItemDAO(KartItemDAO personDAO) {
		this.personDAO = personDAO;
	}

	
	public void addKartItem(KartItem kartItem) {
		this.personDAO.addKartItem(kartItem);
	}

	
	public void updateKartItem(KartItem kartItem) {
		this.personDAO.updateKartItem(kartItem);
	}

	
	public List<KartItem> listKartItems() {
		return this.personDAO.listKartItems();
	}

	
	public KartItem getKartItemById(int id) {
		return this.personDAO.getKartItemById(id);
	}

	
	public void removeKartItem(int id) {
		this.personDAO.removeKartItem(id);
	}

}