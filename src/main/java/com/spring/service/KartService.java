package com.spring.service;

import java.util.List;

import com.spring.model.Kart;

public interface KartService {

	public void addKart(Kart kart);
	public void updateKart(Kart kart);
	public List<Kart> listKarts();
	public Kart getKartById(int id);
	public void removeKart(int id);
	
}