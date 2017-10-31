package com.spring.dao;

import java.util.List;

import com.spring.model.KartItem;

public interface KartItemDAO {
	public void addKartItem(KartItem kartItem);
	public void updateKartItem(KartItem kartItem);
	public List<KartItem> listKartItems();
	public KartItem getKartItemById(int id);
	public void removeKartItem(int id);

}
