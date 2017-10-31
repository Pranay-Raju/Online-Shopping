package com.spring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class KartItem{
	
	@Id
	@GeneratedValue
	private int id;
	private int productId;
//	private int supplierId;
	private int kartId;
	private int quantity;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	/*public int getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}*/
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getKartId() {
		return kartId;
	}
	public void setKartId(int kartId) {
		this.kartId = kartId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "KartItem [id=" + id + ", productId=" + productId + ", kartId=" + kartId + ", quantity=" + quantity
				+ "]";
	}
	
}