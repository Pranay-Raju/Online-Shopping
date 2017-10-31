package com.spring.dao;

import java.util.List;

import com.spring.model.Kart;

public interface KartDAO {
	public void addKart(Kart kart);
	public void updateKart(Kart kart);
	public List<Kart> listKarts();
	public Kart getKartById(int id);
	public void removeKart(int id);

}
