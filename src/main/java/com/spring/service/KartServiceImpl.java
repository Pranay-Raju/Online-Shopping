package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dao.KartDAO;
import com.spring.model.Kart;

@Service
public class KartServiceImpl implements KartService {
	
	@Autowired
	private KartDAO personDAO;

	public void setKartDAO(KartDAO personDAO) {
		this.personDAO = personDAO;
	}

	
	public void addKart(Kart kart) {
		this.personDAO.addKart(kart);
	}

	
	public void updateKart(Kart kart) {
		this.personDAO.updateKart(kart);
	}

	
	public List<Kart> listKarts() {
		return this.personDAO.listKarts();
	}

	
	public Kart getKartById(int id) {
		return this.personDAO.getKartById(id);
	}

	
	public void removeKart(int id) {
		this.personDAO.removeKart(id);
	}

}