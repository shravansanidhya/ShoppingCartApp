package com.mindtree.model;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="product_type")
@Table(name="Product_Stock")
public class Product_Stock {

	@Id
	protected int prodId;
	protected String prodName;
	protected float price;

	public Product_Stock() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Product_Stock(int prodId, String prodName, float price) {
		super();
		this.prodId = prodId;
		this.prodName = prodName;
		this.price = price;
	}

	public int getProdId() {
		return prodId;
	}
	public void setProdId(int prodId) {
		this.prodId = prodId;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
}
